package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bda;
    private int ckQ;
    private boolean clp;
    private l clw;
    private boolean dQq = false;

    public b(l lVar) {
        this.clw = lVar;
    }

    public void eM(boolean z) {
        this.clp = z;
    }

    public void nn(int i) {
        this.ckQ = i;
    }

    public void no(int i) {
        this.bda = i;
    }

    public void hv(boolean z) {
        this.dQq = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.clw != null) {
            if (!this.dQq) {
                this.clw.a(this.ckQ, this.bda, this.clp, 2);
            } else {
                this.clw.a(this.ckQ, this.bda, this.clp, 1);
            }
        }
    }
}
