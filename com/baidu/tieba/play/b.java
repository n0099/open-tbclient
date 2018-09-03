package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int buc;
    private int dnG;
    private boolean dom;
    private m dou;
    private boolean eQP = false;

    public b(m mVar) {
        this.dou = mVar;
    }

    public void fK(boolean z) {
        this.dom = z;
    }

    public void pf(int i) {
        this.dnG = i;
    }

    public void pg(int i) {
        this.buc = i;
    }

    public void iu(boolean z) {
        this.eQP = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dou != null) {
            if (!this.eQP) {
                this.dou.a(this.dnG, this.buc, this.dom, 2);
            } else {
                this.dou.a(this.dnG, this.buc, this.dom, 1);
            }
        }
    }
}
