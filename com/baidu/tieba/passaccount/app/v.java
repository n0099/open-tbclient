package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class v implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SapiFastRegActivity sapiFastRegActivity) {
        this.cdh = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.cdh.finish();
    }
}
