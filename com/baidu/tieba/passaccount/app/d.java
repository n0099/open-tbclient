package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class d implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity enX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForgetPwdActivity forgetPwdActivity) {
        this.enX = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.enX.finish();
    }
}
