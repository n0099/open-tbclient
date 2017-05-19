package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c fLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fLP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.fLP.mWebView;
        if (baseWebView != null) {
            this.fLP.showWebLoadingView(false);
            this.fLP.blN();
        }
    }
}
