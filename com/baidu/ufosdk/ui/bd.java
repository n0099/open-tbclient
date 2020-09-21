package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes21.dex */
final class bd extends TimerTask {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = 3;
        handler = this.a.a.r;
        handler.sendMessage(message);
        timer = this.a.a.q;
        timer.cancel();
        timer2 = this.a.a.q;
        timer2.purge();
    }
}
