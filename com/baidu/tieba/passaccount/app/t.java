package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity cdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.cdc = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.cdc.ccU;
            if (sapiWebView != null) {
                sapiWebView2 = this.cdc.ccU;
                sapiWebView2.destroy();
                this.cdc.ccU = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
