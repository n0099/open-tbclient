package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fED = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fED.dTm;
            if (sapiWebView != null) {
                sapiWebView2 = this.fED.dTm;
                sapiWebView2.destroy();
                this.fED.dTm = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
