package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gpP;
    private i iBV;
    private boolean iVO;
    private int iVe;
    private boolean kTE = false;

    public b(i iVar) {
        this.iBV = iVar;
    }

    public void qg(boolean z) {
        this.iVO = z;
    }

    public void Fq(int i) {
        this.iVe = i;
    }

    public void Fr(int i) {
        this.gpP = i;
    }

    public void tA(boolean z) {
        this.kTE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iBV != null) {
            if (!this.kTE) {
                this.iBV.a(this.iVe, this.gpP, this.iVO, 2);
            } else {
                this.iBV.a(this.iVe, this.gpP, this.iVO, 1);
            }
        }
    }
}
