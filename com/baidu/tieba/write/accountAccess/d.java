package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c fMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fMG = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.fMG.mWebView;
        if (baseWebView != null) {
            this.fMG.showWebLoadingView(false);
            this.fMG.bng();
        }
    }
}
