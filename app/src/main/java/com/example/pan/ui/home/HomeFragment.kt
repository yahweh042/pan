package com.example.pan.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pan.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val webView = view.findViewById<WebView>(R.id.web_view)

        val settings = webView.settings

        settings.builtInZoomControls = true
        settings.allowContentAccess = true
        settings.allowFileAccess = true
        settings.domStorageEnabled = true
        settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
//                webView.loadUrl("javascript:document.getElementsByClassName('logo')[0].remove();")
//                webView.loadUrl("javascript:document.getElementById('content-wrapper').setAttribute('style','padding-top:50px;min-height:683px;');")
//                webView.loadUrl("javascript:document.querySelector('body > div.wrapper.ng-scope > header > nav > div.navbar-toolbar > ul > li:nth-child(10) > a').remove();")
            }
        }


        webView.loadUrl("file:///android_asset/index.html#!/settings/rpc/set?protocol=http&host=127.0.0.1&port=6800&interface=jsonrpc")
    }
}