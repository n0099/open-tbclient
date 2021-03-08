package com.baidu.tieba.lego.card.view;
/* loaded from: classes8.dex */
public class b implements Runnable {
    private int gAO;
    private boolean jkX;
    private int jkn;
    private n lcf;
    private boolean leY = false;

    public b(n nVar) {
        this.lcf = nVar;
    }

    public void qK(boolean z) {
        this.jkX = z;
    }

    public void DZ(int i) {
        this.jkn = i;
    }

    public void Ea(int i) {
        this.gAO = i;
    }

    public void tK(boolean z) {
        this.leY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.lcf != null) {
            if (!this.leY) {
                this.lcf.a(this.jkn, this.gAO, this.jkX, 2);
            }
            this.lcf.a(this.jkn, this.gAO, this.jkX, 1);
        }
    }
}
