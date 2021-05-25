package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22700a;

    public cl(ck ckVar) {
        this.f22700a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22700a.f22699b.f22692a.B) {
                this.f22700a.f22699b.f22692a.a(this.f22700a.f22699b.f22692a, this.f22700a.f22699b.f22692a.f22594f, this.f22700a.f22699b.f22692a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22700a.f22699b.f22692a.f22594f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
