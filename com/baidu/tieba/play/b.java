package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private ac aRh;
    private boolean aRj;
    private int aRk;
    private int aRl;
    private boolean dwm = false;

    public b(ac acVar) {
        this.aRh = acVar;
    }

    public void dU(boolean z) {
        this.aRj = z;
    }

    public void mC(int i) {
        this.aRl = i;
    }

    public void mD(int i) {
        this.aRk = i;
    }

    public void gW(boolean z) {
        this.dwm = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRh != null) {
            if (!this.dwm) {
                this.aRh.a(this.aRl, this.aRk, this.aRj, 2);
            } else {
                this.aRh.a(this.aRl, this.aRk, this.aRj, 1);
            }
        }
    }
}
