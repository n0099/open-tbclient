package com.baidu.tieba.lego.card.view;
/* loaded from: classes9.dex */
public class b implements Runnable {
    private int gzf;
    private int jiE;
    private boolean jjo;
    private n lac;
    private boolean lcV = false;

    public b(n nVar) {
        this.lac = nVar;
    }

    public void qK(boolean z) {
        this.jjo = z;
    }

    public void DW(int i) {
        this.jiE = i;
    }

    public void DX(int i) {
        this.gzf = i;
    }

    public void tK(boolean z) {
        this.lcV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.lac != null) {
            if (!this.lcV) {
                this.lac.a(this.jiE, this.gzf, this.jjo, 2);
            }
            this.lac.a(this.jiE, this.gzf, this.jjo, 1);
        }
    }
}
