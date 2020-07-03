package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int fmb;
    private int hBI;
    private boolean hCs;
    private m hjm;
    private boolean jrG = false;

    public b(m mVar) {
        this.hjm = mVar;
    }

    public void nj(boolean z) {
        this.hCs = z;
    }

    public void zy(int i) {
        this.hBI = i;
    }

    public void zz(int i) {
        this.fmb = i;
    }

    public void qq(boolean z) {
        this.jrG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hjm != null) {
            if (!this.jrG) {
                this.hjm.a(this.hBI, this.fmb, this.hCs, 2);
            } else {
                this.hjm.a(this.hBI, this.fmb, this.hCs, 1);
            }
        }
    }
}
