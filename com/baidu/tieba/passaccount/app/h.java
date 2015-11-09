package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity cdF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForgetPwdActivity forgetPwdActivity) {
        this.cdF = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cdF.cdD;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cdF.cdD;
            sapiWebView2.goBack();
            return;
        }
        this.cdF.finish();
    }
}
