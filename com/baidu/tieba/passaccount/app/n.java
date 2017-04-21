package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ LoginActivity efh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.efh = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.efh.eeZ;
            if (sapiWebView != null) {
                sapiWebView2 = this.efh.eeZ;
                sapiWebView2.destroy();
                this.efh.eeZ = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
