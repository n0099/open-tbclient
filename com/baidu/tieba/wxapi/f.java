package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fWe = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fWe.dUH;
            if (sapiWebView != null) {
                sapiWebView2 = this.fWe.dUH;
                sapiWebView2.destroy();
                this.fWe.dUH = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
