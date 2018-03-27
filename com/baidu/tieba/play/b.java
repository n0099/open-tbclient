package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bZz;
    private int dFA;
    private boolean dGa;
    private m dGi;
    private boolean fbZ = false;

    public b(m mVar) {
        this.dGi = mVar;
    }

    public void fT(boolean z) {
        this.dGa = z;
    }

    public void rd(int i) {
        this.dFA = i;
    }

    public void re(int i) {
        this.bZz = i;
    }

    public void iC(boolean z) {
        this.fbZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dGi != null) {
            if (!this.fbZ) {
                this.dGi.a(this.dFA, this.bZz, this.dGa, 2);
            } else {
                this.dGi.a(this.dFA, this.bZz, this.dGa, 1);
            }
        }
    }
}
