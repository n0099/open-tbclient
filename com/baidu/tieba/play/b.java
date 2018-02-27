package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bZw;
    private boolean dFV;
    private int dFw;
    private m dGd;
    private boolean fbL = false;

    public b(m mVar) {
        this.dGd = mVar;
    }

    public void fT(boolean z) {
        this.dFV = z;
    }

    public void rd(int i) {
        this.dFw = i;
    }

    public void re(int i) {
        this.bZw = i;
    }

    public void ix(boolean z) {
        this.fbL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dGd != null) {
            if (!this.fbL) {
                this.dGd.a(this.dFw, this.bZw, this.dFV, 2);
            } else {
                this.dGd.a(this.dFw, this.bZw, this.dFV, 1);
            }
        }
    }
}
