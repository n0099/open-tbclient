package com.baidu.tieba.kn.pk;

import android.os.Handler;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PKingActivity f1782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PKingActivity pKingActivity) {
        this.f1782a = pKingActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        this.f1782a.b();
        handler = this.f1782a.k;
        handler.postDelayed(this, 1000L);
    }
}
