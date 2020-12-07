package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gpN;
    private i iBT;
    private boolean iVM;
    private int iVc;
    private boolean kTC = false;

    public b(i iVar) {
        this.iBT = iVar;
    }

    public void qg(boolean z) {
        this.iVM = z;
    }

    public void Fq(int i) {
        this.iVc = i;
    }

    public void Fr(int i) {
        this.gpN = i;
    }

    public void tA(boolean z) {
        this.kTC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iBT != null) {
            if (!this.kTC) {
                this.iBT.a(this.iVc, this.gpN, this.iVM, 2);
            } else {
                this.iBT.a(this.iVc, this.gpN, this.iVM, 1);
            }
        }
    }
}
