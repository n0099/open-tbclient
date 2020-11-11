package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int ghW;
    private int iJw;
    private boolean iKg;
    private i iqn;
    private boolean kFV = false;

    public b(i iVar) {
        this.iqn = iVar;
    }

    public void pG(boolean z) {
        this.iKg = z;
    }

    public void Ed(int i) {
        this.iJw = i;
    }

    public void Ee(int i) {
        this.ghW = i;
    }

    public void sV(boolean z) {
        this.kFV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iqn != null) {
            if (!this.kFV) {
                this.iqn.a(this.iJw, this.ghW, this.iKg, 2);
            } else {
                this.iqn.a(this.iJw, this.ghW, this.iKg, 1);
            }
        }
    }
}
