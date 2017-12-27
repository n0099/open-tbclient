package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bXk;
    private int dxP;
    private boolean dyo;
    private m dyw;
    private boolean eUN = false;

    public b(m mVar) {
        this.dyw = mVar;
    }

    public void fE(boolean z) {
        this.dyo = z;
    }

    public void rf(int i) {
        this.dxP = i;
    }

    public void rg(int i) {
        this.bXk = i;
    }

    public void ig(boolean z) {
        this.eUN = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dyw != null) {
            if (!this.eUN) {
                this.dyw.a(this.dxP, this.bXk, this.dyo, 2);
            } else {
                this.dyw.a(this.dxP, this.bXk, this.dyo, 1);
            }
        }
    }
}
