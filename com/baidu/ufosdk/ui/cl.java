package com.baidu.ufosdk.ui;
/* loaded from: classes7.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f3712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f3712a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3712a.b.f3707a.B) {
                this.f3712a.b.f3707a.a(this.f3712a.b.f3707a, this.f3712a.b.f3707a.f, this.f3712a.b.f3707a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f3712a.b.f3707a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
