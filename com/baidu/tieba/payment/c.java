package com.baidu.tieba.payment;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class c extends WebChromeClient {
    private PayVcodeActivity cAt;
    private com.baidu.tieba.tbadkCore.e.c callback;

    public c(PayVcodeActivity payVcodeActivity) {
        this.cAt = payVcodeActivity;
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.callback = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ((this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) && this.cAt != null && com.baidu.adp.lib.h.j.a(this.cAt.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}
