package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class c implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ ForgetPwdActivity ecI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForgetPwdActivity forgetPwdActivity) {
        this.ecI = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.ecI.finish();
    }
}
