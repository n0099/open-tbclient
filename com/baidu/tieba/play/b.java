package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int eke;
    private boolean gqI;
    private m gqP;
    private int gqd;
    private boolean hZl = false;

    public b(m mVar) {
        this.gqP = mVar;
    }

    public void lu(boolean z) {
        this.gqI = z;
    }

    public void xu(int i) {
        this.gqd = i;
    }

    public void xv(int i) {
        this.eke = i;
    }

    public void oz(boolean z) {
        this.hZl = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gqP != null) {
            if (!this.hZl) {
                this.gqP.a(this.gqd, this.eke, this.gqI, 2);
            } else {
                this.gqP.a(this.gqd, this.eke, this.gqI, 1);
            }
        }
    }
}
