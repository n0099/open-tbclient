package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f5499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f5499a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f5499a.f5498b.f5491a.B) {
                this.f5499a.f5498b.f5491a.a(this.f5499a.f5498b.f5491a, this.f5499a.f5498b.f5491a.f, this.f5499a.f5498b.f5491a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f5499a.f5498b.f5491a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
