package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity ecI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForgetPwdActivity forgetPwdActivity) {
        this.ecI = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.ecI.ecH;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.ecI.ecH;
            sapiWebView2.goBack();
            return;
        }
        this.ecI.finish();
    }
}
