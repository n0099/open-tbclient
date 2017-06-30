package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ LoginActivity eoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.eoh = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.eoh.enY;
            if (sapiWebView != null) {
                sapiWebView2 = this.eoh.enY;
                sapiWebView2.destroy();
                this.eoh.enY = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
