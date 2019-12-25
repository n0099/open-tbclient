package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int efC;
    private int gkE;
    private boolean glj;
    private m glq;
    private boolean hTv = false;

    public b(m mVar) {
        this.glq = mVar;
    }

    public void lg(boolean z) {
        this.glj = z;
    }

    public void xj(int i) {
        this.gkE = i;
    }

    public void xk(int i) {
        this.efC = i;
    }

    public void ol(boolean z) {
        this.hTv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.glq != null) {
            if (!this.hTv) {
                this.glq.a(this.gkE, this.efC, this.glj, 2);
            } else {
                this.glq.a(this.gkE, this.efC, this.glj, 1);
            }
        }
    }
}
