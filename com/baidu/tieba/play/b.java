package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bNd;
    private boolean dMO;
    private m dMW;
    private int dMj;
    private boolean fqV = false;

    public b(m mVar) {
        this.dMW = mVar;
    }

    public void gH(boolean z) {
        this.dMO = z;
    }

    public void rh(int i) {
        this.dMj = i;
    }

    public void ri(int i) {
        this.bNd = i;
    }

    public void jA(boolean z) {
        this.fqV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dMW != null) {
            if (!this.fqV) {
                this.dMW.a(this.dMj, this.bNd, this.dMO, 2);
            } else {
                this.dMW.a(this.dMj, this.bNd, this.dMO, 1);
            }
        }
    }
}
