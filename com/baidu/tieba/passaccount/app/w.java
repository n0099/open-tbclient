package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class w implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SapiFastRegActivity sapiFastRegActivity) {
        this.egZ = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.egZ.finish();
    }
}
