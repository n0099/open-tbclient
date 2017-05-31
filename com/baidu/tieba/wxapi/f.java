package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity gci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.gci = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.gci.efe;
            if (sapiWebView != null) {
                sapiWebView2 = this.gci.efe;
                sapiWebView2.destroy();
                this.gci.efe = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
