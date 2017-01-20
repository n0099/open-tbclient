package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class j implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity ece;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.ece = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.ece.finish();
    }
}
