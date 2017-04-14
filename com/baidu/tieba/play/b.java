package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private ac aRf;
    private boolean aRh;
    private int aRi;
    private int aRj;
    private boolean dtV = false;

    public b(ac acVar) {
        this.aRf = acVar;
    }

    public void dK(boolean z) {
        this.aRh = z;
    }

    public void mw(int i) {
        this.aRj = i;
    }

    public void mx(int i) {
        this.aRi = i;
    }

    public void gM(boolean z) {
        this.dtV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRf != null) {
            if (!this.dtV) {
                this.aRf.a(this.aRj, this.aRi, this.aRh, 2);
            } else {
                this.aRf.a(this.aRj, this.aRi, this.aRh, 1);
            }
        }
    }
}
