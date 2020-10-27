package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f3804a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f3804a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3804a.b.f3799a.B) {
                this.f3804a.b.f3799a.a(this.f3804a.b.f3799a, this.f3804a.b.f3799a.f, this.f3804a.b.f3799a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f3804a.b.f3799a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
