package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class i implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ ForgetPwdActivity eey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForgetPwdActivity forgetPwdActivity) {
        this.eey = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.eey.finish();
    }
}
