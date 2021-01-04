package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
final class aw extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f5728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.f5728a = avVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = 3;
        handler = this.f5728a.f5727a.v;
        handler.sendMessage(message);
        timer = this.f5728a.f5727a.p;
        if (timer != null) {
            timer2 = this.f5728a.f5727a.p;
            timer2.cancel();
            timer3 = this.f5728a.f5727a.p;
            timer3.purge();
        }
    }
}
