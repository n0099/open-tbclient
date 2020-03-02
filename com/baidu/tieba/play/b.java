package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int ejR;
    private int gpQ;
    private m gqC;
    private boolean gqv;
    private boolean hYZ = false;

    public b(m mVar) {
        this.gqC = mVar;
    }

    public void lu(boolean z) {
        this.gqv = z;
    }

    public void xu(int i) {
        this.gpQ = i;
    }

    public void xv(int i) {
        this.ejR = i;
    }

    public void oz(boolean z) {
        this.hYZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gqC != null) {
            if (!this.hYZ) {
                this.gqC.a(this.gpQ, this.ejR, this.gqv, 2);
            } else {
                this.gqC.a(this.gpQ, this.ejR, this.gqv, 1);
            }
        }
    }
}
