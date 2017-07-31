package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bcZ;
    private boolean ckE;
    private l ckL;
    private int cke;
    private boolean dOu = false;

    public b(l lVar) {
        this.ckL = lVar;
    }

    public void eK(boolean z) {
        this.ckE = z;
    }

    public void nd(int i) {
        this.cke = i;
    }

    public void ne(int i) {
        this.bcZ = i;
    }

    public void hs(boolean z) {
        this.dOu = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ckL != null) {
            if (!this.dOu) {
                this.ckL.a(this.cke, this.bcZ, this.ckE, 2);
            } else {
                this.ckL.a(this.cke, this.bcZ, this.ckE, 1);
            }
        }
    }
}
