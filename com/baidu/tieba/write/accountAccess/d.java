package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c fKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fKX = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.fKX.mWebView;
        if (baseWebView != null) {
            this.fKX.showWebLoadingView(false);
            this.fKX.bmw();
        }
    }
}
