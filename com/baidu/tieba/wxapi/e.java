package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity feS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.feS = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.feS.dbR;
            if (sapiWebView != null) {
                sapiWebView2 = this.feS.dbR;
                sapiWebView2.destroy();
                this.feS.dbR = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
