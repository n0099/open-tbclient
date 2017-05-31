package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private boolean bVC;
    private ac bVJ;
    private int bVc;
    private int bVd;
    private boolean dvN = false;

    public b(ac acVar) {
        this.bVJ = acVar;
    }

    public void eh(boolean z) {
        this.bVC = z;
    }

    public void mJ(int i) {
        this.bVc = i;
    }

    public void mK(int i) {
        this.bVd = i;
    }

    public void gK(boolean z) {
        this.dvN = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bVJ != null) {
            if (!this.dvN) {
                this.bVJ.a(this.bVc, this.bVd, this.bVC, 2);
            } else {
                this.bVJ.a(this.bVc, this.bVd, this.bVC, 1);
            }
        }
    }
}
