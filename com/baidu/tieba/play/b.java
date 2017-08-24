package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bdb;
    private int ckR;
    private boolean clq;
    private l clx;
    private boolean dQq = false;

    public b(l lVar) {
        this.clx = lVar;
    }

    public void eM(boolean z) {
        this.clq = z;
    }

    public void nn(int i) {
        this.ckR = i;
    }

    public void no(int i) {
        this.bdb = i;
    }

    public void hv(boolean z) {
        this.dQq = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.clx != null) {
            if (!this.dQq) {
                this.clx.a(this.ckR, this.bdb, this.clq, 2);
            } else {
                this.clx.a(this.ckR, this.bdb, this.clq, 1);
            }
        }
    }
}
