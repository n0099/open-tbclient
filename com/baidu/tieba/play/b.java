package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bNP;
    private int dMS;
    private m dNF;
    private boolean dNx;
    private boolean frQ = false;

    public b(m mVar) {
        this.dNF = mVar;
    }

    public void gK(boolean z) {
        this.dNx = z;
    }

    public void rj(int i) {
        this.dMS = i;
    }

    public void rk(int i) {
        this.bNP = i;
    }

    public void jA(boolean z) {
        this.frQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dNF != null) {
            if (!this.frQ) {
                this.dNF.a(this.dMS, this.bNP, this.dNx, 2);
            } else {
                this.dNF.a(this.dMS, this.bNP, this.dNx, 1);
            }
        }
    }
}
