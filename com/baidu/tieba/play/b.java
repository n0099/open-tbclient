package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int ejQ;
    private int gpO;
    private m gqA;
    private boolean gqt;
    private boolean hYX = false;

    public b(m mVar) {
        this.gqA = mVar;
    }

    public void lu(boolean z) {
        this.gqt = z;
    }

    public void xu(int i) {
        this.gpO = i;
    }

    public void xv(int i) {
        this.ejQ = i;
    }

    public void oz(boolean z) {
        this.hYX = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gqA != null) {
            if (!this.hYX) {
                this.gqA.a(this.gpO, this.ejQ, this.gqt, 2);
            } else {
                this.gqA.a(this.gpO, this.ejQ, this.gqt, 1);
            }
        }
    }
}
