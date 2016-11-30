package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity eoM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.eoM = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.eoM.eoG;
            if (sapiWebView != null) {
                sapiWebView2 = this.eoM.eoG;
                sapiWebView2.destroy();
                this.eoM.eoG = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
