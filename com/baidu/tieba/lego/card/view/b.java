package com.baidu.tieba.lego.card.view;
/* loaded from: classes8.dex */
public class b implements Runnable {
    private int gwh;
    private int jcJ;
    private boolean jdt;
    private n kRM;
    private boolean kUD = false;

    public b(n nVar) {
        this.kRM = nVar;
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
        if (this.kRM != null) {
            if (!this.kUD) {
                this.kRM.a(this.jcJ, this.gwh, this.jdt, 2);
            }
            this.kRM.a(this.jcJ, this.gwh, this.jdt, 1);
        }
    }
}
