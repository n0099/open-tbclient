package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22816a;

    public cl(ck ckVar) {
        this.f22816a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22816a.f22815b.f22808a.B) {
                this.f22816a.f22815b.f22808a.a(this.f22816a.f22815b.f22808a, this.f22816a.f22815b.f22808a.f22713f, this.f22816a.f22815b.f22808a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22816a.f22815b.f22808a.f22713f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
