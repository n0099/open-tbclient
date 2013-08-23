package com.baidu.tieba.service;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MessagePullService f1714a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MessagePullService messagePullService) {
        this.f1714a = messagePullService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        this.f1714a.a();
        handler = this.f1714a.d;
        runnable = this.f1714a.c;
        handler.removeCallbacks(runnable);
        handler2 = this.f1714a.d;
        runnable2 = this.f1714a.c;
        handler2.postDelayed(runnable2, com.baidu.tieba.data.g.c.longValue());
    }
}
