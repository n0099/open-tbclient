package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int fSe;
    private i hXO;
    private boolean irN;
    private int ird;
    private boolean knE = false;

    public b(i iVar) {
        this.hXO = iVar;
    }

    public void pf(boolean z) {
        this.irN = z;
    }

    public void Dx(int i) {
        this.ird = i;
    }

    public void Dy(int i) {
        this.fSe = i;
    }

    public void su(boolean z) {
        this.knE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hXO != null) {
            if (!this.knE) {
                this.hXO.a(this.ird, this.fSe, this.irN, 2);
            } else {
                this.hXO.a(this.ird, this.fSe, this.irN, 1);
            }
        }
    }
}
