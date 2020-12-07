package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f3809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f3809a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3809a.b.f3804a.B) {
                this.f3809a.b.f3804a.a(this.f3809a.b.f3804a, this.f3809a.b.f3804a.f, this.f3809a.b.f3804a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f3809a.b.f3804a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
