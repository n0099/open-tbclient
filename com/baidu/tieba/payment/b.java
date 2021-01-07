package com.baidu.tieba.payment;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.lib.f.g;
/* loaded from: classes9.dex */
public class b extends WebChromeClient {
    private com.baidu.tieba.tbadkCore.e.c callback;
    private PayVcodeActivity lDf;

    public b(PayVcodeActivity payVcodeActivity) {
        this.lDf = payVcodeActivity;
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.callback = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ((this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) && this.lDf != null && g.a(this.lDf.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}
