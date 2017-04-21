package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class t implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity efq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SapiFastRegActivity sapiFastRegActivity) {
        this.efq = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.efq.finish();
    }
}
