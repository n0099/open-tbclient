package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
final class aw extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f5729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.f5729a = avVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = 3;
        handler = this.f5729a.f5728a.v;
        handler.sendMessage(message);
        timer = this.f5729a.f5728a.p;
        if (timer != null) {
            timer2 = this.f5729a.f5728a.p;
            timer2.cancel();
            timer3 = this.f5729a.f5728a.p;
            timer3.purge();
        }
    }
}
