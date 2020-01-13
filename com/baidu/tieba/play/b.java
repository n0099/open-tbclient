package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int efM;
    private int gnN;
    private boolean gos;
    private m goz;
    private boolean hWZ = false;

    public b(m mVar) {
        this.goz = mVar;
    }

    public void lr(boolean z) {
        this.gos = z;
    }

    public void xo(int i) {
        this.gnN = i;
    }

    public void xp(int i) {
        this.efM = i;
    }

    public void ox(boolean z) {
        this.hWZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.goz != null) {
            if (!this.hWZ) {
                this.goz.a(this.gnN, this.efM, this.gos, 2);
            } else {
                this.goz.a(this.gnN, this.efM, this.gos, 1);
            }
        }
    }
}
