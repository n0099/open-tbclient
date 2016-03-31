package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity cZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.cZE = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.cZE.cZw;
            if (sapiWebView != null) {
                sapiWebView2 = this.cZE.cZw;
                sapiWebView2.destroy();
                this.cZE.cZw = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
