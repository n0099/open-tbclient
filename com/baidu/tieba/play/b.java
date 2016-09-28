package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private k aMo;
    private boolean aMq;
    private int aMs;
    private int aMt;
    private boolean eYn = false;

    public b(k kVar) {
        this.aMo = kVar;
    }

    public void dN(boolean z) {
        this.aMq = z;
    }

    public void qv(int i) {
        this.aMt = i;
    }

    public void qw(int i) {
        this.aMs = i;
    }

    public void jW(boolean z) {
        this.eYn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aMo != null) {
            if (!this.eYn) {
                this.aMo.a(this.aMt, this.aMs, this.aMq, 2);
            }
            this.aMo.a(this.aMt, this.aMs, this.aMq, 1);
        }
    }
}
