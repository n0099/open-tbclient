package com.baidu.ufosdk.d;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes5.dex */
public final class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final String f22682a = "InjectedChromeClient";

    /* renamed from: b  reason: collision with root package name */
    public b f22683b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22684c;

    public a(String str, Class cls) {
        this.f22683b = new b(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.f22683b.a(webView, str2));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        if (i2 <= 25) {
            this.f22684c = false;
        } else if (!this.f22684c) {
            webView.loadUrl(this.f22683b.a());
            this.f22684c = true;
            com.baidu.ufosdk.f.c.a("InjectedChromeClient --> inject js interface completely on progress " + i2);
        }
        super.onProgressChanged(webView, i2);
    }
}
