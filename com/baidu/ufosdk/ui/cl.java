package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f3806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f3806a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3806a.b.f3801a.B) {
                this.f3806a.b.f3801a.a(this.f3806a.b.f3801a, this.f3806a.b.f3801a.f, this.f3806a.b.f3801a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f3806a.b.f3801a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
