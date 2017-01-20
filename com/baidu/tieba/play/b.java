package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private ac aLe;
    private boolean aLg;
    private int aLh;
    private int aLi;
    private boolean duE = false;

    public b(ac acVar) {
        this.aLe = acVar;
    }

    public void dI(boolean z) {
        this.aLg = z;
    }

    public void mH(int i) {
        this.aLi = i;
    }

    public void mI(int i) {
        this.aLh = i;
    }

    public void gV(boolean z) {
        this.duE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aLe != null) {
            if (!this.duE) {
                this.aLe.a(this.aLi, this.aLh, this.aLg, 2);
            }
            this.aLe.a(this.aLi, this.aLh, this.aLg, 1);
        }
    }
}
