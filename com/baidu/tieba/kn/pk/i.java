package com.baidu.tieba.kn.pk;

import android.os.Handler;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKWaitingActivity f1281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PKWaitingActivity pKWaitingActivity) {
        this.f1281a = pKWaitingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        this.f1281a.b();
        handler = this.f1281a.g;
        handler.postDelayed(this, 1000L);
    }
}
