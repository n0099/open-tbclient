package com.baidu.tieba.service;

import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MessagePullService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MessagePullService messagePullService) {
        this.a = messagePullService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        this.a.a();
        handler = this.a.d;
        runnable = this.a.c;
        handler.removeCallbacks(runnable);
        handler2 = this.a.d;
        runnable2 = this.a.c;
        handler2.postDelayed(runnable2, com.baidu.tieba.a.h.a.longValue());
    }
}
