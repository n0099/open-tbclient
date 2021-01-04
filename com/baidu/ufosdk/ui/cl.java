package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f5779a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f5779a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f5779a.f5778b.f5771a.B) {
                this.f5779a.f5778b.f5771a.a(this.f5779a.f5778b.f5771a, this.f5779a.f5778b.f5771a.f, this.f5779a.f5778b.f5771a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f5779a.f5778b.f5771a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
