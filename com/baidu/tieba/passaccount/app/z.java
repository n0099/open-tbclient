package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class z implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity eoV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SapiFastRegActivity sapiFastRegActivity) {
        this.eoV = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.eoV.finish();
    }
}
