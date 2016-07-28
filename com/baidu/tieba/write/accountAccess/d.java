package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c fPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fPL = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.fPL.mWebView;
        if (baseWebView != null) {
            this.fPL.lq(false);
            this.fPL.bnd();
        }
    }
}
