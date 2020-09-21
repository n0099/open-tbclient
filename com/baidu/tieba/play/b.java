package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int fFV;
    private i hIT;
    private boolean icM;
    private int icc;
    private boolean jYo = false;

    public b(i iVar) {
        this.hIT = iVar;
    }

    public void oA(boolean z) {
        this.icM = z;
    }

    public void CR(int i) {
        this.icc = i;
    }

    public void CS(int i) {
        this.fFV = i;
    }

    public void rN(boolean z) {
        this.jYo = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hIT != null) {
            if (!this.jYo) {
                this.hIT.a(this.icc, this.fFV, this.icM, 2);
            } else {
                this.hIT.a(this.icc, this.fFV, this.icM, 1);
            }
        }
    }
}
