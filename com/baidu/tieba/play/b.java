package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int btu;
    private int dkR;
    private m dlE;
    private boolean dlw;
    private boolean eMZ = false;

    public b(m mVar) {
        this.dlE = mVar;
    }

    public void fI(boolean z) {
        this.dlw = z;
    }

    public void oQ(int i) {
        this.dkR = i;
    }

    public void oR(int i) {
        this.btu = i;
    }

    public void ir(boolean z) {
        this.eMZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dlE != null) {
            if (!this.eMZ) {
                this.dlE.a(this.dkR, this.btu, this.dlw, 2);
            } else {
                this.dlE.a(this.dkR, this.btu, this.dlw, 1);
            }
        }
    }
}
