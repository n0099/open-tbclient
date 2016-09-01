package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity ggj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.ggj = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.ggj.egN;
            if (sapiWebView != null) {
                sapiWebView2 = this.ggj.egN;
                sapiWebView2.destroy();
                this.ggj.egN = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
