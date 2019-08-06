package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dms;
    private int fvX;
    private boolean fwC;
    private m fwJ;
    private boolean hgj = false;

    public b(m mVar) {
        this.fwJ = mVar;
    }

    public void kd(boolean z) {
        this.fwC = z;
    }

    public void wz(int i) {
        this.fvX = i;
    }

    public void wA(int i) {
        this.dms = i;
    }

    public void nf(boolean z) {
        this.hgj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fwJ != null) {
            if (!this.hgj) {
                this.fwJ.a(this.fvX, this.dms, this.fwC, 2);
            } else {
                this.fwJ.a(this.fvX, this.dms, this.fwC, 1);
            }
        }
    }
}
