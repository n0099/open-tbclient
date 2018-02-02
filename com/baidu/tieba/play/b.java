package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bXz;
    private int dCL;
    private boolean dDk;
    private m dDs;
    private boolean eWI = false;

    public b(m mVar) {
        this.dDs = mVar;
    }

    public void fL(boolean z) {
        this.dDk = z;
    }

    public void qY(int i) {
        this.dCL = i;
    }

    public void qZ(int i) {
        this.bXz = i;
    }

    public void im(boolean z) {
        this.eWI = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dDs != null) {
            if (!this.eWI) {
                this.dDs.a(this.dCL, this.bXz, this.dDk, 2);
            } else {
                this.dDs.a(this.dCL, this.bXz, this.dDk, 1);
            }
        }
    }
}
