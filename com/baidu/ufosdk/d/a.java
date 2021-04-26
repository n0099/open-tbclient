package com.baidu.ufosdk.d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes5.dex */
public final class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final String f23323a = "InjectedChromeClient";

    /* renamed from: b  reason: collision with root package name */
    public b f23324b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23325c;

    public a(String str, Class cls) {
        this.f23324b = new b(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.f23324b.a(webView, str2));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        if (i2 <= 25) {
            this.f23325c = false;
        } else if (!this.f23325c) {
            webView.loadUrl(this.f23324b.a());
            this.f23325c = true;
            com.baidu.ufosdk.f.c.a("InjectedChromeClient --> inject js interface completely on progress " + i2);
        }
        super.onProgressChanged(webView, i2);
    }
}
