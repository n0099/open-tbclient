package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class c implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity fKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.fKn = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        Runnable runnable;
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        runnable = this.fKn.fKm;
        dM.postDelayed(runnable, 500L);
    }
}
