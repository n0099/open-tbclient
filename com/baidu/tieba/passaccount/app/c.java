package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity dIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FillUProfileActivity fillUProfileActivity) {
        this.dIw = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.dIw.dIv;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.dIw.dIv;
            sapiWebView2.goBack();
            return;
        }
        this.dIw.finish();
    }
}
