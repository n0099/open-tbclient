package com.baidu.tieba.lego.card.view;
/* loaded from: classes9.dex */
public class b implements Runnable {
    private int gyR;
    private int jiq;
    private boolean jja;
    private n kZO;
    private boolean lcH = false;

    public b(n nVar) {
        this.kZO = nVar;
    }

    public void qK(boolean z) {
        this.jja = z;
    }

    public void DW(int i) {
        this.jiq = i;
    }

    public void DX(int i) {
        this.gyR = i;
    }

    public void tK(boolean z) {
        this.lcH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.kZO != null) {
            if (!this.lcH) {
                this.kZO.a(this.jiq, this.gyR, this.jja, 2);
            }
            this.kZO.a(this.jiq, this.gyR, this.jja, 1);
        }
    }
}
