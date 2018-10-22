package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bIA;
    private int dBF;
    private boolean dCk;
    private m dCs;
    private boolean ffS = false;

    public b(m mVar) {
        this.dCs = mVar;
    }

    public void gt(boolean z) {
        this.dCk = z;
    }

    public void qh(int i) {
        this.dBF = i;
    }

    public void qi(int i) {
        this.bIA = i;
    }

    public void jk(boolean z) {
        this.ffS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dCs != null) {
            if (!this.ffS) {
                this.dCs.a(this.dBF, this.bIA, this.dCk, 2);
            } else {
                this.dCs.a(this.dBF, this.bIA, this.dCk, 1);
            }
        }
    }
}
