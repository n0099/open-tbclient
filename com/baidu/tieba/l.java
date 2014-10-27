package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.ls();
            this.acP.q(this.acP.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.acP.mHandler;
        handler2 = this.acP.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
