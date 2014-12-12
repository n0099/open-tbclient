package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.on();
            this.akC.q(this.akC.getPageContext().getPageActivity().getCacheDir());
        } catch (Exception e) {
        }
        handler = this.akC.mHandler;
        handler2 = this.akC.mHandler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
