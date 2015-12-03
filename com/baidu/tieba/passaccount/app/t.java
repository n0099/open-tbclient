package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity cwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.cwm = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.cwm.cwe;
            if (sapiWebView != null) {
                sapiWebView2 = this.cwm.cwe;
                sapiWebView2.destroy();
                this.cwm.cwe = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
