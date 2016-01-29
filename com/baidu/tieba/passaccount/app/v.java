package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class v implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity cGB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SapiFastRegActivity sapiFastRegActivity) {
        this.cGB = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.cGB.finish();
    }
}
