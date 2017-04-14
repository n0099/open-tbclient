package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ LoginActivity ecR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.ecR = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.ecR.ecJ;
            if (sapiWebView != null) {
                sapiWebView2 = this.ecR.ecJ;
                sapiWebView2.destroy();
                this.ecR.ecJ = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
