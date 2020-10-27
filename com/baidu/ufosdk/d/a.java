package com.baidu.ufosdk.d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes22.dex */
public final class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f3705a = "InjectedChromeClient";
    private b b;
    private boolean c;

    public a(String str, Class cls) {
        this.b = new b(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.b.a(webView, str2));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (i <= 25) {
            this.c = false;
        } else if (!this.c) {
            webView.loadUrl(this.b.a());
            this.c = true;
            com.baidu.ufosdk.f.c.a("InjectedChromeClient --> inject js interface completely on progress " + i);
        }
        super.onProgressChanged(webView, i);
    }
}
