package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int beu;
    private boolean crM;
    private m crT;
    private int crn;
    private boolean dTQ = false;

    public b(m mVar) {
        this.crT = mVar;
    }

    public void eF(boolean z) {
        this.crM = z;
    }

    public void nD(int i) {
        this.crn = i;
    }

    public void nE(int i) {
        this.beu = i;
    }

    public void hq(boolean z) {
        this.dTQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.crT != null) {
            if (!this.dTQ) {
                this.crT.a(this.crn, this.beu, this.crM, 2);
            } else {
                this.crT.a(this.crn, this.beu, this.crM, 1);
            }
        }
    }
}
