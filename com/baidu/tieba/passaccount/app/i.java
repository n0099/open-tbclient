package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity dZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LoginActivity loginActivity) {
        this.dZQ = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.dZQ.finish();
    }
}
