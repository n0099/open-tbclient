package com.baidu.tieba.lego.card.view;
/* loaded from: classes9.dex */
public class b implements Runnable {
    private int gAO;
    private int jhq;
    private boolean jia;
    private n kWr;
    private boolean kZi = false;

    public b(n nVar) {
        this.kWr = nVar;
    }

    public void qE(boolean z) {
        this.jia = z;
    }

    public void Fk(int i) {
        this.jhq = i;
    }

    public void Fl(int i) {
        this.gAO = i;
    }

    public void tB(boolean z) {
        this.kZi = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.kWr != null) {
            if (!this.kZi) {
                this.kWr.a(this.jhq, this.gAO, this.jia, 2);
            }
            this.kWr.a(this.jhq, this.gAO, this.jia, 1);
        }
    }
}
