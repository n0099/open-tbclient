package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity dRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.dRQ = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dRQ.cwe;
            if (sapiWebView != null) {
                sapiWebView2 = this.dRQ.cwe;
                sapiWebView2.destroy();
                this.dRQ.cwe = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
