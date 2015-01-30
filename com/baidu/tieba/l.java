package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.alk = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.oq();
            this.alk.t(this.alk.getPageContext().getPageActivity().getCacheDir());
        } catch (Exception e) {
        }
        handler = this.alk.mHandler;
        handler2 = this.alk.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
