package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c fZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fZP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.fZP.mWebView;
        if (baseWebView != null) {
            this.fZP.lG(false);
            this.fZP.brt();
        }
    }
}
