package com.baidu.tieba.wxapi;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ WXEntryActivity eNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.eNU = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.eNU.cZw;
            if (sapiWebView != null) {
                sapiWebView2 = this.eNU.cZw;
                sapiWebView2.destroy();
                this.eNU.cZw = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
