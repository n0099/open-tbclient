package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private f aJx;
    private boolean aLm;
    private int aLq;
    private int aLr;
    private boolean ePd = false;

    public b(f fVar) {
        this.aJx = fVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(boolean z) {
        this.aLm = z;
    }

    public void pL(int i) {
        this.aLr = i;
    }

    public void pM(int i) {
        this.aLq = i;
    }

    public void jF(boolean z) {
        this.ePd = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aJx != null) {
            if (!this.ePd) {
                this.aJx.a(this.aLr, this.aLq, this.aLm, 2);
            }
            this.aJx.a(this.aLr, this.aLq, this.aLm, 1);
        }
    }
}
