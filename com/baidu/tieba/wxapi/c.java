package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class c implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity ggj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.ggj = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        Runnable runnable;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.ggj.ggi;
        eG.postDelayed(runnable, 500L);
    }
}
