package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gwh;
    private i iJA;
    private int jcJ;
    private boolean jdt;
    private boolean kUD = false;

    public b(i iVar) {
        this.iJA = iVar;
    }

    public void qA(boolean z) {
        this.jdt = z;
    }

    public void DE(int i) {
        this.jcJ = i;
    }

    public void DF(int i) {
        this.gwh = i;
    }

    public void tx(boolean z) {
        this.kUD = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iJA != null) {
            if (!this.kUD) {
                this.iJA.a(this.jcJ, this.gwh, this.jdt, 2);
            } else {
                this.iJA.a(this.jcJ, this.gwh, this.jdt, 1);
            }
        }
    }
}
