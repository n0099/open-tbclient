package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity dsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.dsL = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dsL.cdG;
            if (sapiWebView != null) {
                sapiWebView2 = this.dsL.cdG;
                sapiWebView2.destroy();
                this.dsL.cdG = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
