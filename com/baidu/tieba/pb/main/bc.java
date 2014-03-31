package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements Runnable {
    final /* synthetic */ bb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.a = bbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        this.a.f = true;
        bb bbVar = this.a;
        i = bbVar.i;
        bbVar.i = i + 30;
        i2 = this.a.i;
        if (i2 > 360) {
            bb bbVar2 = this.a;
            i3 = bbVar2.i;
            bbVar2.i = i3 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
