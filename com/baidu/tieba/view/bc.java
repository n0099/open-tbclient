package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f2670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.f2670a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.f2670a.f = true;
        bb.a(this.f2670a, 30);
        i = this.f2670a.i;
        if (i > 360) {
            bb bbVar = this.f2670a;
            i2 = this.f2670a.i;
            bbVar.i = i2 - 360;
        }
        this.f2670a.invalidate(this.f2670a.getRotateInvalidRect());
        this.f2670a.postDelayed(this.f2670a.e, 50L);
    }
}
