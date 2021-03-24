package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class aw extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av f23070a;

    public aw(av avVar) {
        this.f23070a = avVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = 3;
        handler = this.f23070a.f23069a.v;
        handler.sendMessage(message);
        timer = this.f23070a.f23069a.p;
        if (timer != null) {
            timer2 = this.f23070a.f23069a.p;
            timer2.cancel();
            timer3 = this.f23070a.f23069a.p;
            timer3.purge();
        }
    }
}
