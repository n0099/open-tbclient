package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bNa;
    private int dJv;
    private boolean dKa;
    private m dKi;
    private boolean fod = false;

    public b(m mVar) {
        this.dKi = mVar;
    }

    public void gE(boolean z) {
        this.dKa = z;
    }

    public void qU(int i) {
        this.dJv = i;
    }

    public void qV(int i) {
        this.bNa = i;
    }

    public void jx(boolean z) {
        this.fod = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dKi != null) {
            if (!this.fod) {
                this.dKi.a(this.dJv, this.bNa, this.dKa, 2);
            } else {
                this.dKi.a(this.dJv, this.bNa, this.dKa, 1);
            }
        }
    }
}
