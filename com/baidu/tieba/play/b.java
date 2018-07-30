package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bua;
    private int dnI;
    private boolean doo;
    private m dow;
    private boolean eQU = false;

    public b(m mVar) {
        this.dow = mVar;
    }

    public void fK(boolean z) {
        this.doo = z;
    }

    public void pf(int i) {
        this.dnI = i;
    }

    public void pg(int i) {
        this.bua = i;
    }

    public void iu(boolean z) {
        this.eQU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dow != null) {
            if (!this.eQU) {
                this.dow.a(this.dnI, this.bua, this.doo, 2);
            } else {
                this.dow.a(this.dnI, this.bua, this.doo, 1);
            }
        }
    }
}
