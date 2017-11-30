package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjU;
    private boolean cIE;
    private m cIL;
    private int cIg;
    private boolean ehy = false;

    public b(m mVar) {
        this.cIL = mVar;
    }

    public void eX(boolean z) {
        this.cIE = z;
    }

    public void og(int i) {
        this.cIg = i;
    }

    public void oh(int i) {
        this.bjU = i;
    }

    public void hG(boolean z) {
        this.ehy = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cIL != null) {
            if (!this.ehy) {
                this.cIL.a(this.cIg, this.bjU, this.cIE, 2);
            } else {
                this.cIL.a(this.cIg, this.bjU, this.cIE, 1);
            }
        }
    }
}
