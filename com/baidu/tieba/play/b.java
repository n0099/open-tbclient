package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjz;
    private boolean cYX;
    private int cYv;
    private m cZf;
    private boolean ewH = false;

    public b(m mVar) {
        this.cZf = mVar;
    }

    public void fy(boolean z) {
        this.cYX = z;
    }

    public void oz(int i) {
        this.cYv = i;
    }

    public void oA(int i) {
        this.bjz = i;
    }

    public void ia(boolean z) {
        this.ewH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cZf != null) {
            if (!this.ewH) {
                this.cZf.a(this.cYv, this.bjz, this.cYX, 2);
            } else {
                this.cZf.a(this.cYv, this.bjz, this.cYX, 1);
            }
        }
    }
}
