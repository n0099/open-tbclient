package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes22.dex */
final class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bc f3771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.f3771a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = 3;
        handler = this.f3771a.f3770a.r;
        handler.sendMessage(message);
        timer = this.f3771a.f3770a.q;
        timer.cancel();
        timer2 = this.f3771a.f3770a.q;
        timer2.purge();
    }
}
