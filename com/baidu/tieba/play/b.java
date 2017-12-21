package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjZ;
    private boolean cIR;
    private m cIZ;
    private int cIt;
    private boolean eiH = false;

    public b(m mVar) {
        this.cIZ = mVar;
    }

    public void eY(boolean z) {
        this.cIR = z;
    }

    public void on(int i) {
        this.cIt = i;
    }

    public void oo(int i) {
        this.bjZ = i;
    }

    public void hH(boolean z) {
        this.eiH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cIZ != null) {
            if (!this.eiH) {
                this.cIZ.a(this.cIt, this.bjZ, this.cIR, 2);
            } else {
                this.cIZ.a(this.cIt, this.bjZ, this.cIR, 1);
            }
        }
    }
}
