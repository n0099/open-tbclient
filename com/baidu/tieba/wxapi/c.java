package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class c implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity fTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.fTG = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        Runnable runnable;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.fTG.mFinishRunnable;
        fS.postDelayed(runnable, 500L);
    }
}
