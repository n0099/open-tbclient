package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class l extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.a.getApplication();
            tiebaApplication.b(tiebaApplication.y() + 1);
            if (tiebaApplication.C()) {
                com.baidu.tieba.c.k.w();
                tiebaApplication.b(0);
            }
            com.baidu.tieba.c.k.s();
            com.baidu.tieba.c.k.v();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.g;
        handler2 = this.a.g;
        handler.sendMessage(handler2.obtainMessage());
    }
}
