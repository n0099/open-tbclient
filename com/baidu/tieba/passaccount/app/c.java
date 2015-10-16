package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FillUProfileActivity fillUProfileActivity) {
        this.cdd = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cdd.cdc;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cdd.cdc;
            sapiWebView2.goBack();
            return;
        }
        this.cdd.finish();
    }
}
