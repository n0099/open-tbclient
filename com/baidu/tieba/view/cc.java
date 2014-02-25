package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Runnable {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.a = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        this.a.f = true;
        cb cbVar = this.a;
        i = cbVar.i;
        cbVar.i = i + 30;
        i2 = this.a.i;
        if (i2 > 360) {
            cb cbVar2 = this.a;
            i3 = cbVar2.i;
            cbVar2.i = i3 - 360;
        }
        this.a.invalidate(this.a.getRotateInvalidRect());
        this.a.postDelayed(this.a.e, 50L);
    }
}
