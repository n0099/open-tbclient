package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjz;
    private boolean cYU;
    private int cYs;
    private m cZc;
    private boolean ewE = false;

    public b(m mVar) {
        this.cZc = mVar;
    }

    public void fy(boolean z) {
        this.cYU = z;
    }

    public void oy(int i) {
        this.cYs = i;
    }

    public void oz(int i) {
        this.bjz = i;
    }

    public void ia(boolean z) {
        this.ewE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cZc != null) {
            if (!this.ewE) {
                this.cZc.a(this.cYs, this.bjz, this.cYU, 2);
            } else {
                this.cZc.a(this.cYs, this.bjz, this.cYU, 1);
            }
        }
    }
}
