package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class aw extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av f22833a;

    public aw(av avVar) {
        this.f22833a = avVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = 3;
        handler = this.f22833a.f22832a.v;
        handler.sendMessage(message);
        timer = this.f22833a.f22832a.p;
        if (timer != null) {
            timer2 = this.f22833a.f22832a.p;
            timer2.cancel();
            timer3 = this.f22833a.f22832a.p;
            timer3.purge();
        }
    }
}
