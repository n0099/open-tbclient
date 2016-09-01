package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity egU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity) {
        this.egU = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.egU.finish();
    }
}
