package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fMW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fMW = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fMW.ecf;
            if (sapiWebView != null) {
                sapiWebView2 = this.fMW.ecf;
                sapiWebView2.destroy();
                this.fMW.ecf = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
