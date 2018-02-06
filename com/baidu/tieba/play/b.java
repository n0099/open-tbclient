package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bZI;
    private int dFI;
    private boolean dGh;
    private m dGp;
    private boolean fbX = false;

    public b(m mVar) {
        this.dGp = mVar;
    }

    public void fT(boolean z) {
        this.dGh = z;
    }

    public void rc(int i) {
        this.dFI = i;
    }

    public void rd(int i) {
        this.bZI = i;
    }

    public void ix(boolean z) {
        this.fbX = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dGp != null) {
            if (!this.fbX) {
                this.dGp.a(this.dFI, this.bZI, this.dGh, 2);
            } else {
                this.dGp.a(this.dFI, this.bZI, this.dGh, 1);
            }
        }
    }
}
