package com.baidu.tieba.service;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MessagePullService f1699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MessagePullService messagePullService) {
        this.f1699a = messagePullService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        this.f1699a.a();
        handler = this.f1699a.d;
        runnable = this.f1699a.c;
        handler.removeCallbacks(runnable);
        handler2 = this.f1699a.d;
        runnable2 = this.f1699a.c;
        handler2.postDelayed(runnable2, com.baidu.tieba.data.g.c.longValue());
    }
}
