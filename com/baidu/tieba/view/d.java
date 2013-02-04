package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class d extends WebViewClient {
    final /* synthetic */ BaseWebView a;

    public d(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        e eVar;
        e eVar2;
        eVar = this.a.b;
        if (eVar == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        eVar2 = this.a.b;
        return eVar2.a(webView, str);
    }
}
