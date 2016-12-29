package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private aa aMd;
    private boolean aMf;
    private int aMg;
    private int aMh;
    private boolean eIn = false;

    public b(aa aaVar) {
        this.aMd = aaVar;
    }

    public void dC(boolean z) {
        this.aMf = z;
    }

    public void pJ(int i) {
        this.aMh = i;
    }

    public void pK(int i) {
        this.aMg = i;
    }

    public void kg(boolean z) {
        this.eIn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aMd != null) {
            if (!this.eIn) {
                this.aMd.a(this.aMh, this.aMg, this.aMf, 2);
            }
            this.aMd.a(this.aMh, this.aMg, this.aMf, 1);
        }
    }
}
