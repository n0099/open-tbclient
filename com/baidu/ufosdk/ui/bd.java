package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
final class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bc f5457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.f5457a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = 3;
        handler = this.f5457a.f5456a.r;
        handler.sendMessage(message);
        timer = this.f5457a.f5456a.q;
        timer.cancel();
        timer2 = this.f5457a.f5456a.q;
        timer2.purge();
    }
}
