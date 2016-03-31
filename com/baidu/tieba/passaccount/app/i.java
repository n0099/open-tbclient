package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class i implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity cZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForgetPwdActivity forgetPwdActivity) {
        this.cZv = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.cZv.finish();
    }
}
