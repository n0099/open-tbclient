package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int duA;
    private boolean fwM;
    private m fwT;
    private int fwh;
    private boolean hfr = false;

    public b(m mVar) {
        this.fwT = mVar;
    }

    public void jU(boolean z) {
        this.fwM = z;
    }

    public void vh(int i) {
        this.fwh = i;
    }

    public void vi(int i) {
        this.duA = i;
    }

    public void mW(boolean z) {
        this.hfr = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fwT != null) {
            if (!this.hfr) {
                this.fwT.a(this.fwh, this.duA, this.fwM, 2);
            } else {
                this.fwT.a(this.fwh, this.duA, this.fwM, 1);
            }
        }
    }
}
