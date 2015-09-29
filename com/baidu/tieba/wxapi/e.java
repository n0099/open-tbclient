package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity dqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.dqt = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dqt.ccU;
            if (sapiWebView != null) {
                sapiWebView2 = this.dqt.ccU;
                sapiWebView2.destroy();
                this.dqt.ccU = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
