package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int eNZ;
    private m gHB;
    private boolean haL;
    private int hac;
    private boolean iKJ = false;

    public b(m mVar) {
        this.gHB = mVar;
    }

    public void mD(boolean z) {
        this.haL = z;
    }

    public void yc(int i) {
        this.hac = i;
    }

    public void yd(int i) {
        this.eNZ = i;
    }

    public void pJ(boolean z) {
        this.iKJ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gHB != null) {
            if (!this.iKJ) {
                this.gHB.a(this.hac, this.eNZ, this.haL, 2);
            } else {
                this.gHB.a(this.hac, this.eNZ, this.haL, 1);
            }
        }
    }
}
