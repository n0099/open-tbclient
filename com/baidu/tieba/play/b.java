package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int beI;
    private boolean crY;
    private int crz;
    private m csf;
    private boolean dUe = false;

    public b(m mVar) {
        this.csf = mVar;
    }

    public void eG(boolean z) {
        this.crY = z;
    }

    public void nE(int i) {
        this.crz = i;
    }

    public void nF(int i) {
        this.beI = i;
    }

    public void hr(boolean z) {
        this.dUe = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.csf != null) {
            if (!this.dUe) {
                this.csf.a(this.crz, this.beI, this.crY, 2);
            } else {
                this.csf.a(this.crz, this.beI, this.crY, 1);
            }
        }
    }
}
