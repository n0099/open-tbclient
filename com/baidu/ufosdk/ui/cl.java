package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22771a;

    public cl(ck ckVar) {
        this.f22771a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22771a.f22770b.f22763a.B) {
                this.f22771a.f22770b.f22763a.a(this.f22771a.f22770b.f22763a, this.f22771a.f22770b.f22763a.f22665f, this.f22771a.f22770b.f22763a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22771a.f22770b.f22763a.f22665f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
