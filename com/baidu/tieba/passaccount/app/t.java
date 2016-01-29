package com.baidu.tieba.passaccount.app;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.cGw = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.cGw.cGo;
            if (sapiWebView != null) {
                sapiWebView2 = this.cGw.cGo;
                sapiWebView2.destroy();
                this.cGw.cGo = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
