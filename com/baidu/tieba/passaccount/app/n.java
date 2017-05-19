package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ LoginActivity dZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.dZQ = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dZQ.dZI;
            if (sapiWebView != null) {
                sapiWebView2 = this.dZQ.dZI;
                sapiWebView2.destroy();
                this.dZQ.dZI = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
