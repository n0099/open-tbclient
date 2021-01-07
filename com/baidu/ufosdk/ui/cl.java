package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f5780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f5780a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f5780a.f5779b.f5772a.B) {
                this.f5780a.f5779b.f5772a.a(this.f5780a.f5779b.f5772a, this.f5780a.f5779b.f5772a.f, this.f5780a.f5779b.f5772a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f5780a.f5779b.f5772a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
