package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjP;
    private int cZz;
    private boolean dab;
    private m daj;
    private boolean exN = false;

    public b(m mVar) {
        this.daj = mVar;
    }

    public void fz(boolean z) {
        this.dab = z;
    }

    public void ox(int i) {
        this.cZz = i;
    }

    public void oy(int i) {
        this.bjP = i;
    }

    public void ib(boolean z) {
        this.exN = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.daj != null) {
            if (!this.exN) {
                this.daj.a(this.cZz, this.bjP, this.dab, 2);
            } else {
                this.daj.a(this.cZz, this.bjP, this.dab, 1);
            }
        }
    }
}
