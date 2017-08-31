package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bcY;
    private boolean cqJ;
    private l cqQ;
    private int cqk;
    private boolean dXc = false;

    public b(l lVar) {
        this.cqQ = lVar;
    }

    public void eP(boolean z) {
        this.cqJ = z;
    }

    public void nG(int i) {
        this.cqk = i;
    }

    public void nH(int i) {
        this.bcY = i;
    }

    public void hD(boolean z) {
        this.dXc = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cqQ != null) {
            if (!this.dXc) {
                this.cqQ.a(this.cqk, this.bcY, this.cqJ, 2);
            } else {
                this.cqQ.a(this.cqk, this.bcY, this.cqJ, 1);
            }
        }
    }
}
