package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity enX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForgetPwdActivity forgetPwdActivity) {
        this.enX = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.enX.enW;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.enX.enW;
            sapiWebView2.goBack();
            return;
        }
        this.enX.finish();
    }
}
