package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity efd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForgetPwdActivity forgetPwdActivity) {
        this.efd = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.efd.efc;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.efd.efc;
            sapiWebView2.goBack();
            return;
        }
        this.efd.finish();
    }
}
