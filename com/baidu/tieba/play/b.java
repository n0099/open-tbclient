package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int cZU;
    private boolean faQ;
    private m faX;
    private int faj;
    private boolean gHG = false;

    public b(m mVar) {
        this.faX = mVar;
    }

    public void jj(boolean z) {
        this.faQ = z;
    }

    public void uO(int i) {
        this.faj = i;
    }

    public void uP(int i) {
        this.cZU = i;
    }

    public void mb(boolean z) {
        this.gHG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.faX != null) {
            if (!this.gHG) {
                this.faX.a(this.faj, this.cZU, this.faQ, 2);
            } else {
                this.faX.a(this.faj, this.cZU, this.faQ, 1);
            }
        }
    }
}
