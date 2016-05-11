package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ LoginActivity dbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.dbZ = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dbZ.dbR;
            if (sapiWebView != null) {
                sapiWebView2 = this.dbZ.dbR;
                sapiWebView2.destroy();
                this.dbZ.dbR = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
