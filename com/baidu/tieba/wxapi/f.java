package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WXEntryActivity fVx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.fVx = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.fVx.eeZ;
            if (sapiWebView != null) {
                sapiWebView2 = this.fVx.eeZ;
                sapiWebView2.destroy();
                this.fVx.eeZ = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
