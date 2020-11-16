package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int ghD;
    private boolean iKT;
    private int iKj;
    private i irb;
    private boolean kGk = false;

    public b(i iVar) {
        this.irb = iVar;
    }

    public void pJ(boolean z) {
        this.iKT = z;
    }

    public void EB(int i) {
        this.iKj = i;
    }

    public void EC(int i) {
        this.ghD = i;
    }

    public void sY(boolean z) {
        this.kGk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.irb != null) {
            if (!this.kGk) {
                this.irb.a(this.iKj, this.ghD, this.iKT, 2);
            } else {
                this.irb.a(this.iKj, this.ghD, this.iKT, 1);
            }
        }
    }
}
