package com.baidu.tieba.passaccount.app;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class d implements SapiWebView.OnFinishCallback {
    final /* synthetic */ FillUProfileActivity cGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FillUProfileActivity fillUProfileActivity) {
        this.cGm = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.cGm.finish();
    }
}
