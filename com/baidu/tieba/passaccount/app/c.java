package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity cZu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FillUProfileActivity fillUProfileActivity) {
        this.cZu = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cZu.cZt;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cZu.cZt;
            sapiWebView2.goBack();
            return;
        }
        this.cZu.finish();
    }
}
