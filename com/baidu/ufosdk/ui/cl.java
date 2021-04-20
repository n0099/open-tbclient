package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22808a;

    public cl(ck ckVar) {
        this.f22808a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22808a.f22807b.f22800a.B) {
                this.f22808a.f22807b.f22800a.a(this.f22808a.f22807b.f22800a, this.f22808a.f22807b.f22800a.f22705f, this.f22808a.f22807b.f22800a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22808a.f22807b.f22800a.f22705f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
