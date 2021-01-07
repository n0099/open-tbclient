package com.baidu.ufosdk.d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes8.dex */
public final class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f5651a = "InjectedChromeClient";

    /* renamed from: b  reason: collision with root package name */
    private b f5652b;
    private boolean c;

    public a(String str, Class cls) {
        this.f5652b = new b(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.f5652b.a(webView, str2));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (i <= 25) {
            this.c = false;
        } else if (!this.c) {
            webView.loadUrl(this.f5652b.a());
            this.c = true;
            com.baidu.ufosdk.f.c.a("InjectedChromeClient --> inject js interface completely on progress " + i);
        }
        super.onProgressChanged(webView, i);
    }
}
