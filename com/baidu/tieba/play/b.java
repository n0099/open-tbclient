package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int cZV;
    private boolean faQ;
    private m faX;
    private int fak;
    private boolean gHH = false;

    public b(m mVar) {
        this.faX = mVar;
    }

    public void jj(boolean z) {
        this.faQ = z;
    }

    public void uO(int i) {
        this.fak = i;
    }

    public void uP(int i) {
        this.cZV = i;
    }

    public void mb(boolean z) {
        this.gHH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.faX != null) {
            if (!this.gHH) {
                this.faX.a(this.fak, this.cZV, this.faQ, 2);
            } else {
                this.faX.a(this.fak, this.cZV, this.faQ, 1);
            }
        }
    }
}
