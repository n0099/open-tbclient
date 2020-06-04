package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int faR;
    private m gWx;
    private boolean hpK;
    private int hpb;
    private boolean jaw = false;

    public b(m mVar) {
        this.gWx = mVar;
    }

    public void mY(boolean z) {
        this.hpK = z;
    }

    public void yM(int i) {
        this.hpb = i;
    }

    public void yN(int i) {
        this.faR = i;
    }

    public void qg(boolean z) {
        this.jaw = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gWx != null) {
            if (!this.jaw) {
                this.gWx.a(this.hpb, this.faR, this.hpK, 2);
            } else {
                this.gWx.a(this.hpb, this.faR, this.hpK, 1);
            }
        }
    }
}
