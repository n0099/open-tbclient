package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes21.dex */
final class aw extends TimerTask {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = 3;
        handler = this.a.a.v;
        handler.sendMessage(message);
        timer = this.a.a.p;
        if (timer != null) {
            timer2 = this.a.a.p;
            timer2.cancel();
            timer3 = this.a.a.p;
            timer3.purge();
        }
    }
}
