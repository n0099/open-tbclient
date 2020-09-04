package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int fCJ;
    private i hBR;
    private boolean hVM;
    private int hVc;
    private boolean jPL = false;

    public b(i iVar) {
        this.hBR = iVar;
    }

    public void ou(boolean z) {
        this.hVM = z;
    }

    public void Cq(int i) {
        this.hVc = i;
    }

    public void Cr(int i) {
        this.fCJ = i;
    }

    public void rF(boolean z) {
        this.jPL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hBR != null) {
            if (!this.jPL) {
                this.hBR.a(this.hVc, this.fCJ, this.hVM, 2);
            } else {
                this.hBR.a(this.hVc, this.fCJ, this.hVM, 1);
            }
        }
    }
}
