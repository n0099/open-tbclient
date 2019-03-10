package com.baidu.tieba.lego.card.view;
/* loaded from: classes2.dex */
public class b implements Runnable {
    private int cZV;
    private int fay;
    private boolean fbe;
    private l gEY;
    private boolean gHU = false;

    public b(l lVar) {
        this.gEY = lVar;
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
        this.gHU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.gEY != null) {
            if (!this.gHU) {
                this.gEY.a(this.fay, this.cZV, this.fbe, 2);
            }
            this.gEY.a(this.fay, this.cZV, this.fbe, 1);
        }
    }
}
