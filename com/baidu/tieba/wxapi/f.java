package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity gng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.gng = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.gng.enY;
            if (sapiWebView != null) {
                sapiWebView2 = this.gng.enY;
                sapiWebView2.destroy();
                this.gng.enY = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
