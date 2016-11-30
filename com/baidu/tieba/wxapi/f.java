package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity gqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.gqf = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.gqf.eoG;
            if (sapiWebView != null) {
                sapiWebView2 = this.gqf.eoG;
                sapiWebView2.destroy();
                this.gqf.eoG = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
