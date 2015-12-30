package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.czQ = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.czQ.finish();
    }
}
