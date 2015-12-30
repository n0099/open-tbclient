package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class b implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity dZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WXEntryActivity wXEntryActivity) {
        this.dZo = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.dZo.closeActivity();
    }
}
