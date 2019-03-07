package com.baidu.tieba.lego.card.view;
/* loaded from: classes2.dex */
public class b implements Runnable {
    private int cZV;
    private int fay;
    private boolean fbe;
    private l gEX;
    private boolean gHT = false;

    public b(l lVar) {
        this.gEX = lVar;
    }

    public void jj(boolean z) {
        this.fbe = z;
    }

    public void uS(int i) {
        this.fay = i;
    }

    public void uT(int i) {
        this.cZV = i;
    }

    public void mb(boolean z) {
        this.gHT = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gEX != null) {
            if (!this.gHT) {
                this.gEX.a(this.fay, this.cZV, this.fbe, 2);
            }
            this.gEX.a(this.fay, this.cZV, this.fbe, 1);
        }
    }
}
