package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c geh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.geh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseWebView baseWebView;
        baseWebView = this.geh.mWebView;
        if (baseWebView != null) {
            this.geh.showWebLoadingView(false);
            this.geh.brH();
        }
    }
}
