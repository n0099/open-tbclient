package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bcV;
    private boolean crC;
    private l crJ;
    private int crd;
    private boolean dXW = false;

    public b(l lVar) {
        this.crJ = lVar;
    }

    public void eQ(boolean z) {
        this.crC = z;
    }

    public void nI(int i) {
        this.crd = i;
    }

    public void nJ(int i) {
        this.bcV = i;
    }

    public void hE(boolean z) {
        this.dXW = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.crJ != null) {
            if (!this.dXW) {
                this.crJ.a(this.crd, this.bcV, this.crC, 2);
            } else {
                this.crJ.a(this.crd, this.bcV, this.crC, 1);
            }
        }
    }
}
