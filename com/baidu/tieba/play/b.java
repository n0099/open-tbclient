package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private i aNV;
    private boolean aPX;
    private int aQb;
    private int aQc;
    private boolean eWj = false;

    public b(i iVar) {
        this.aNV = iVar;
    }

    public void dM(boolean z) {
        this.aPX = z;
    }

    public void qk(int i) {
        this.aQc = i;
    }

    public void ql(int i) {
        this.aQb = i;
    }

    public void jT(boolean z) {
        this.eWj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNV != null) {
            if (!this.eWj) {
                this.aNV.a(this.aQc, this.aQb, this.aPX, 2);
            }
            this.aNV.a(this.aQc, this.aQb, this.aPX, 1);
        }
    }
}
