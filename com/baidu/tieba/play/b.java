package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dml;
    private int fvy;
    private boolean fwd;
    private m fwk;
    private boolean hfr = false;

    public b(m mVar) {
        this.fwk = mVar;
    }

    public void kd(boolean z) {
        this.fwd = z;
    }

    public void wx(int i) {
        this.fvy = i;
    }

    public void wy(int i) {
        this.dml = i;
    }

    public void nf(boolean z) {
        this.hfr = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fwk != null) {
            if (!this.hfr) {
                this.fwk.a(this.fvy, this.dml, this.fwd, 2);
            } else {
                this.fwk.a(this.fvy, this.dml, this.fwd, 1);
            }
        }
    }
}
