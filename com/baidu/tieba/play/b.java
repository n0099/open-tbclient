package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bXr;
    private boolean dCP;
    private m dCX;
    private int dCq;
    private boolean eWn = false;

    public b(m mVar) {
        this.dCX = mVar;
    }

    public void fI(boolean z) {
        this.dCP = z;
    }

    public void qY(int i) {
        this.dCq = i;
    }

    public void qZ(int i) {
        this.bXr = i;
    }

    public void ij(boolean z) {
        this.eWn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dCX != null) {
            if (!this.eWn) {
                this.dCX.a(this.dCq, this.bXr, this.dCP, 2);
            } else {
                this.dCX.a(this.dCq, this.bXr, this.dCP, 1);
            }
        }
    }
}
