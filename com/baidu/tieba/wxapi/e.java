package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity dqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.dqT = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dqT.cdf;
            if (sapiWebView != null) {
                sapiWebView2 = this.dqT.cdf;
                sapiWebView2.destroy();
                this.dqT.cdf = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
