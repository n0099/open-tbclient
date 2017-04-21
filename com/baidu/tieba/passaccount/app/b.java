package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity eeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForgetPwdActivity forgetPwdActivity) {
        this.eeY = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.eeY.eeX;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.eeY.eeX;
            sapiWebView2.goBack();
            return;
        }
        this.eeY.finish();
    }
}
