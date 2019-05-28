package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dkD;
    private int fqA;
    private boolean frf;
    private m frm;
    private boolean gZe = false;

    public b(m mVar) {
        this.frm = mVar;
    }

    public void jT(boolean z) {
        this.frf = z;
    }

    public void vV(int i) {
        this.fqA = i;
    }

    public void vW(int i) {
        this.dkD = i;
    }

    public void mQ(boolean z) {
        this.gZe = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.frm != null) {
            if (!this.gZe) {
                this.frm.a(this.fqA, this.dkD, this.frf, 2);
            } else {
                this.frm.a(this.fqA, this.dkD, this.frf, 1);
            }
        }
    }
}
