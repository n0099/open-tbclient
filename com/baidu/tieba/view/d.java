package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class d extends WebViewClient {
    final /* synthetic */ BaseWebView a;

    public d(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        g gVar;
        g gVar2;
        super.onPageStarted(webView, str, bitmap);
        gVar = this.a.e;
        if (gVar != null) {
            gVar2 = this.a.e;
            gVar2.c(webView, str);
        }
        Log.d("BaseWebView", "@onPageStarted = " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        f fVar;
        f fVar2;
        super.onPageFinished(webView, str);
        fVar = this.a.f;
        if (fVar != null) {
            fVar2 = this.a.f;
            fVar2.b(webView, str);
        }
        Log.d("BaseWebView", "@onPageFinished = " + str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        e eVar;
        e eVar2;
        eVar = this.a.b;
        if (eVar != null) {
            eVar2 = this.a.b;
            return eVar2.a(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
