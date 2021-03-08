package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gAO;
    private i iRf;
    private boolean jkX;
    private int jkn;
    private boolean leY = false;

    public b(i iVar) {
        this.iRf = iVar;
    }

    public void qK(boolean z) {
        this.jkX = z;
    }

    public void DZ(int i) {
        this.jkn = i;
    }

    public void Ea(int i) {
        this.gAO = i;
    }

    public void tK(boolean z) {
        this.leY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iRf != null) {
            if (!this.leY) {
                this.iRf.a(this.jkn, this.gAO, this.jkX, 2);
            } else {
                this.iRf.a(this.jkn, this.gAO, this.jkX, 1);
            }
        }
    }
}
