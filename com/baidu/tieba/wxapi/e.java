package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity dex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.dex = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dex.agG;
            if (sapiWebView != null) {
                sapiWebView2 = this.dex.agG;
                sapiWebView2.destroy();
                this.dex.agG = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
