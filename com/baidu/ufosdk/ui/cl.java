package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class cl implements Runnable {
    final /* synthetic */ ck a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.b.a.B) {
                this.a.b.a.a(this.a.b.a, this.a.b.a.f, this.a.b.a.A);
            }
            com.baidu.ufosdk.e.a.a(this.a.b.a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
