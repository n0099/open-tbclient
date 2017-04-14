package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fTb = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fTb.ecJ;
            if (sapiWebView != null) {
                sapiWebView2 = this.fTb.ecJ;
                sapiWebView2.destroy();
                this.fTb.ecJ = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
