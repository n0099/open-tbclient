package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fTG = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fTG.dZI;
            if (sapiWebView != null) {
                sapiWebView2 = this.fTG.dZI;
                sapiWebView2.destroy();
                this.fTG.dZI = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
