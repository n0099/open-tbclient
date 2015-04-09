package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class k extends Thread {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.e.rG();
            this.atK.s(this.atK.getPageContext().getPageActivity().getCacheDir());
        } catch (Exception e) {
        }
        handler = this.atK.mHandler;
        handler2 = this.atK.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
