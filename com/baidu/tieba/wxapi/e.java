package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity eud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.eud = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.eud.cGo;
            if (sapiWebView != null) {
                sapiWebView2 = this.eud.cGo;
                sapiWebView2.destroy();
                this.eud.cGo = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
