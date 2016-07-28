package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ LoginActivity dUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.dUO = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dUO.dUH;
            if (sapiWebView != null) {
                sapiWebView2 = this.dUO.dUH;
                sapiWebView2.destroy();
                this.dUO.dUH = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
