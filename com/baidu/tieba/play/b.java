package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int faG;
    private m gWm;
    private int hoQ;
    private boolean hpz;
    private boolean iZJ = false;

    public b(m mVar) {
        this.gWm = mVar;
    }

    public void mY(boolean z) {
        this.hpz = z;
    }

    public void yK(int i) {
        this.hoQ = i;
    }

    public void yL(int i) {
        this.faG = i;
    }

    public void qg(boolean z) {
        this.iZJ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gWm != null) {
            if (!this.iZJ) {
                this.gWm.a(this.hoQ, this.faG, this.hpz, 2);
            } else {
                this.gWm.a(this.hoQ, this.faG, this.hpz, 1);
            }
        }
    }
}
