package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class k extends Thread {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.e.rG();
            this.atC.s(this.atC.getPageContext().getPageActivity().getCacheDir());
        } catch (Exception e) {
        }
        handler = this.atC.mHandler;
        handler2 = this.atC.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
