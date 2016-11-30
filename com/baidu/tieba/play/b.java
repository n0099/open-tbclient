package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private aa aMM;
    private boolean aMO;
    private int aMP;
    private int aMQ;
    private boolean feM = false;

    public b(aa aaVar) {
        this.aMM = aaVar;
    }

    public void dU(boolean z) {
        this.aMO = z;
    }

    public void qI(int i) {
        this.aMQ = i;
    }

    public void qJ(int i) {
        this.aMP = i;
    }

    public void kw(boolean z) {
        this.feM = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aMM != null) {
            if (!this.feM) {
                this.aMM.a(this.aMQ, this.aMP, this.aMO, 2);
            }
            this.aMM.a(this.aMQ, this.aMP, this.aMO, 1);
        }
    }
}
