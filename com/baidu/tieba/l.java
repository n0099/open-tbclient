package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.ls();
            this.acU.q(this.acU.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.acU.mHandler;
        handler2 = this.acU.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
