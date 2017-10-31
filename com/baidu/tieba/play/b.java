package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bfl;
    private int cyI;
    private boolean czg;
    private m czn;
    private boolean ebD = false;

    public b(m mVar) {
        this.czn = mVar;
    }

    public void eB(boolean z) {
        this.czg = z;
    }

    public void nU(int i) {
        this.cyI = i;
    }

    public void nV(int i) {
        this.bfl = i;
    }

    public void hm(boolean z) {
        this.ebD = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.czn != null) {
            if (!this.ebD) {
                this.czn.a(this.cyI, this.bfl, this.czg, 2);
            } else {
                this.czn.a(this.cyI, this.bfl, this.czg, 1);
            }
        }
    }
}
