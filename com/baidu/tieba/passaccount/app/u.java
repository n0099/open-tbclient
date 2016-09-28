package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ LoginActivity eiO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.eiO = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.eiO.eiH;
            if (sapiWebView != null) {
                sapiWebView2 = this.eiO.eiH;
                sapiWebView2.destroy();
                this.eiO.eiH = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
