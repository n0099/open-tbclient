package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ c fMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.fMG = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseWebView baseWebView;
        baseActivity = this.fMG.mContext;
        if (baseActivity != null) {
            baseActivity2 = this.fMG.mContext;
            baseWebView = this.fMG.mWebView;
            baseActivity2.ShowSoftKeyPadDelay(baseWebView);
        }
    }
}
