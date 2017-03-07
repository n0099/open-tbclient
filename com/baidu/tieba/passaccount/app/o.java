package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity eeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity) {
        this.eeH = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.eeH.finish();
    }
}
