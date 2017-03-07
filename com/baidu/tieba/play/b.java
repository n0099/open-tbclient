package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private ac aQP;
    private boolean aQR;
    private int aQS;
    private int aQT;
    private boolean dxg = false;

    public b(ac acVar) {
        this.aQP = acVar;
    }

    public void dI(boolean z) {
        this.aQR = z;
    }

    public void mx(int i) {
        this.aQT = i;
    }

    public void my(int i) {
        this.aQS = i;
    }

    public void gM(boolean z) {
        this.dxg = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aQP != null) {
            if (!this.dxg) {
                this.aQP.a(this.aQT, this.aQS, this.aQR, 2);
            } else {
                this.aQP.a(this.aQT, this.aQS, this.aQR, 1);
            }
        }
    }
}
