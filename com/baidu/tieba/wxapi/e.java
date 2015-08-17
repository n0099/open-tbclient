package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import java.util.TimerTask;
/* loaded from: classes.dex */
class e extends TimerTask {
    final /* synthetic */ WXEntryActivity cVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.cVt = wXEntryActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cVt.agw;
        if (sapiWebView != null) {
            sapiWebView2 = this.cVt.agw;
            sapiWebView2.destroy();
            this.cVt.agw = null;
        }
    }
}
