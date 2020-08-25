package com.baidu.tieba.play;
/* loaded from: classes2.dex */
public class b implements Runnable {
    private int fCF;
    private i hBL;
    private int hUW;
    private boolean hVG;
    private boolean jPF = false;

    public b(i iVar) {
        this.hBL = iVar;
    }

    public void os(boolean z) {
        this.hVG = z;
    }

    public void Cq(int i) {
        this.hUW = i;
    }

    public void Cr(int i) {
        this.fCF = i;
    }

    public void rD(boolean z) {
        this.jPF = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hBL != null) {
            if (!this.jPF) {
                this.hBL.a(this.hUW, this.fCF, this.hVG, 2);
            } else {
                this.hBL.a(this.hUW, this.fCF, this.hVG, 1);
            }
        }
    }
}
