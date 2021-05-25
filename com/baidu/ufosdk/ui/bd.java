package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bc f22657a;

    public bd(bc bcVar) {
        this.f22657a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = 3;
        handler = this.f22657a.f22656a.r;
        handler.sendMessage(message);
        timer = this.f22657a.f22656a.q;
        timer.cancel();
        timer2 = this.f22657a.f22656a.q;
        timer2.purge();
    }
}
