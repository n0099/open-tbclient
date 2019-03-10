package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int cZV;
    private int fay;
    private boolean fbe;
    private m fbl;
    private boolean gHU = false;

    public b(m mVar) {
        this.fbl = mVar;
    }

    public void jj(boolean z) {
        this.fbe = z;
    }

    public void uS(int i) {
        this.fay = i;
    }

    public void uT(int i) {
        this.cZV = i;
    }

    public void mb(boolean z) {
        this.gHU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fbl != null) {
            if (!this.gHU) {
                this.fbl.a(this.fay, this.cZV, this.fbe, 2);
            } else {
                this.fbl.a(this.fay, this.cZV, this.fbe, 1);
            }
        }
    }
}
