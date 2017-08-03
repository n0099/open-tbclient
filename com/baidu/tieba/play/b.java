package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bbP;
    private int ciX;
    private l cjD;
    private boolean cjw;
    private boolean dNd = false;

    public b(l lVar) {
        this.cjD = lVar;
    }

    public void eK(boolean z) {
        this.cjw = z;
    }

    public void nd(int i) {
        this.ciX = i;
    }

    public void ne(int i) {
        this.bbP = i;
    }

    public void hs(boolean z) {
        this.dNd = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cjD != null) {
            if (!this.dNd) {
                this.cjD.a(this.ciX, this.bbP, this.cjw, 2);
            } else {
                this.cjD.a(this.ciX, this.bbP, this.cjw, 1);
            }
        }
    }
}
