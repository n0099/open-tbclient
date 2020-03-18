package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int eku;
    private int gqN;
    private boolean grs;
    private m grz;
    private boolean iaL = false;

    public b(m mVar) {
        this.grz = mVar;
    }

    public void lA(boolean z) {
        this.grs = z;
    }

    public void xC(int i) {
        this.gqN = i;
    }

    public void xD(int i) {
        this.eku = i;
    }

    public void oF(boolean z) {
        this.iaL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.grz != null) {
            if (!this.iaL) {
                this.grz.a(this.gqN, this.eku, this.grs, 2);
            } else {
                this.grz.a(this.gqN, this.eku, this.grs, 1);
            }
        }
    }
}
