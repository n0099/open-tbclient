package com.baidu.tieba.write.accountAccess;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ c fTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.fTw = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseWebView baseWebView;
        baseActivity = this.fTw.mContext;
        if (baseActivity != null) {
            baseActivity2 = this.fTw.mContext;
            baseWebView = this.fTw.mWebView;
            baseActivity2.ShowSoftKeyPadDelay(baseWebView);
        }
    }
}
