package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.a.f = true;
        ba.a(this.a, 30);
        i = this.a.i;
        if (i > 360) {
            ba baVar = this.a;
            i2 = this.a.i;
            baVar.i = i2 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
