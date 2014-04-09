package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be implements Runnable {
    final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.a = bdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        this.a.f = true;
        bd bdVar = this.a;
        i = bdVar.i;
        bdVar.i = i + 30;
        i2 = this.a.i;
        if (i2 > 360) {
            bd bdVar2 = this.a;
            i3 = bdVar2.i;
            bdVar2.i = i3 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
