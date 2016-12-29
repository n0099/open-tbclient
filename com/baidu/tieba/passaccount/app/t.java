package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity dTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.dTt = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.dTt.dTm;
            if (sapiWebView != null) {
                sapiWebView2 = this.dTt.dTm;
                sapiWebView2.destroy();
                this.dTt.dTm = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
