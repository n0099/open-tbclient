package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ c geh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.geh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseWebView baseWebView;
        baseActivity = this.geh.mContext;
        if (baseActivity != null) {
            baseActivity2 = this.geh.mContext;
            baseWebView = this.geh.mWebView;
            baseActivity2.ShowSoftKeyPadDelay(baseWebView);
        }
    }
}
