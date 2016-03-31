package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity cZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForgetPwdActivity forgetPwdActivity) {
        this.cZv = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cZv.cZt;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cZv.cZt;
            sapiWebView2.goBack();
            return;
        }
        this.cZv.finish();
    }
}
