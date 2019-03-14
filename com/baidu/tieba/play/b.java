package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int cZR;
    private int fax;
    private boolean fbd;
    private m fbk;
    private boolean gHT = false;

    public b(m mVar) {
        this.fbk = mVar;
    }

    public void jj(boolean z) {
        this.fbd = z;
    }

    public void uS(int i) {
        this.fax = i;
    }

    public void uT(int i) {
        this.cZR = i;
    }

    public void mb(boolean z) {
        this.gHT = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fbk != null) {
            if (!this.gHT) {
                this.fbk.a(this.fax, this.cZR, this.fbd, 2);
            } else {
                this.fbk.a(this.fax, this.cZR, this.fbd, 1);
            }
        }
    }
}
