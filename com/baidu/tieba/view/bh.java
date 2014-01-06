package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.a.f = true;
        bg.a(this.a, 30);
        i = this.a.i;
        if (i > 360) {
            bg bgVar = this.a;
            i2 = this.a.i;
            bgVar.i = i2 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
