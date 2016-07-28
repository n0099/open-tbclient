package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class c implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity fWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.fWe = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        Runnable runnable;
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.fWe.fWd;
        dL.postDelayed(runnable, 500L);
    }
}
