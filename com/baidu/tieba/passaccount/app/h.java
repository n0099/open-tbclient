package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity czH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForgetPwdActivity forgetPwdActivity) {
        this.czH = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.czH.czF;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.czH.czF;
            sapiWebView2.goBack();
            return;
        }
        this.czH.finish();
    }
}
