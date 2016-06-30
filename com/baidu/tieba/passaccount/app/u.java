package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ LoginActivity dIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.dIF = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dIF.dIy;
            if (sapiWebView != null) {
                sapiWebView2 = this.dIF.dIy;
                sapiWebView2.destroy();
                this.dIF.dIy = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
