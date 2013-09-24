package com.baidu.tieba.kn.pk;

import android.os.Handler;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PKingActivity pKingActivity) {
        this.f1287a = pKingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        this.f1287a.b();
        handler = this.f1287a.k;
        handler.postDelayed(this, 1000L);
    }
}
