package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private ac aRC;
    private boolean aRE;
    private int aRF;
    private int aRG;
    private boolean dqv = false;

    public b(ac acVar) {
        this.aRC = acVar;
    }

    public void dR(boolean z) {
        this.aRE = z;
    }

    public void mp(int i) {
        this.aRG = i;
    }

    public void mq(int i) {
        this.aRF = i;
    }

    public void gx(boolean z) {
        this.dqv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRC != null) {
            if (!this.dqv) {
                this.aRC.a(this.aRG, this.aRF, this.aRE, 2);
            } else {
                this.aRC.a(this.aRG, this.aRF, this.aRE, 1);
            }
        }
    }
}
