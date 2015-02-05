package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.alh = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.oj();
            this.alh.t(this.alh.getPageContext().getPageActivity().getCacheDir());
        } catch (Exception e) {
        }
        handler = this.alh.mHandler;
        handler2 = this.alh.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
