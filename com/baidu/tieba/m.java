package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class m extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            com.baidu.tbadk.core.util.i.a();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.i;
        handler2 = this.a.i;
        handler.sendMessage(handler2.obtainMessage());
    }
}
