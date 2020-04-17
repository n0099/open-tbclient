package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int eNU;
    private m gHv;
    private int gZW;
    private boolean haF;
    private boolean iKF = false;

    public b(m mVar) {
        this.gHv = mVar;
    }

    public void mD(boolean z) {
        this.haF = z;
    }

    public void yc(int i) {
        this.gZW = i;
    }

    public void yd(int i) {
        this.eNU = i;
    }

    public void pJ(boolean z) {
        this.iKF = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gHv != null) {
            if (!this.iKF) {
                this.gHv.a(this.gZW, this.eNU, this.haF, 2);
            } else {
                this.gHv.a(this.gZW, this.eNU, this.haF, 1);
            }
        }
    }
}
