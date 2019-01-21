package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bNQ;
    private int dMT;
    private m dNG;
    private boolean dNy;
    private boolean frR = false;

    public b(m mVar) {
        this.dNG = mVar;
    }

    public void gK(boolean z) {
        this.dNy = z;
    }

    public void rj(int i) {
        this.dMT = i;
    }

    public void rk(int i) {
        this.bNQ = i;
    }

    public void jA(boolean z) {
        this.frR = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dNG != null) {
            if (!this.frR) {
                this.dNG.a(this.dMT, this.bNQ, this.dNy, 2);
            } else {
                this.dNG.a(this.dMT, this.bNQ, this.dNy, 1);
            }
        }
    }
}
