package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dvr;
    private int fwY;
    private boolean fxD;
    private m fxK;
    private boolean hgi = false;

    public b(m mVar) {
        this.fxK = mVar;
    }

    public void jU(boolean z) {
        this.fxD = z;
    }

    public void vi(int i) {
        this.fwY = i;
    }

    public void vj(int i) {
        this.dvr = i;
    }

    public void mW(boolean z) {
        this.hgi = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fxK != null) {
            if (!this.hgi) {
                this.fxK.a(this.fwY, this.dvr, this.fxD, 2);
            } else {
                this.fxK.a(this.fwY, this.dvr, this.fxD, 1);
            }
        }
    }
}
