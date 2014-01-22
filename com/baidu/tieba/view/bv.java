package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.a = buVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.a.f = true;
        bu.a(this.a, 30);
        i = this.a.i;
        if (i > 360) {
            bu buVar = this.a;
            i2 = this.a.i;
            buVar.i = i2 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
