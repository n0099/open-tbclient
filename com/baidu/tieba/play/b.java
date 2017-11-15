package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bfu;
    private m czG;
    private int czb;
    private boolean czz;
    private boolean ebH = false;

    public b(m mVar) {
        this.czG = mVar;
    }

    public void eG(boolean z) {
        this.czz = z;
    }

    public void nV(int i) {
        this.czb = i;
    }

    public void nW(int i) {
        this.bfu = i;
    }

    public void hs(boolean z) {
        this.ebH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.czG != null) {
            if (!this.ebH) {
                this.czG.a(this.czb, this.bfu, this.czz, 2);
            } else {
                this.czG.a(this.czb, this.bfu, this.czz, 1);
            }
        }
    }
}
