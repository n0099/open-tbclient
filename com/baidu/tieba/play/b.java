package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int frk;
    private int hHG;
    private boolean hIq;
    private i hoU;
    private boolean jAl = false;

    public b(i iVar) {
        this.hoU = iVar;
    }

    public void nO(boolean z) {
        this.hIq = z;
    }

    public void zX(int i) {
        this.hHG = i;
    }

    public void zY(int i) {
        this.frk = i;
    }

    public void qX(boolean z) {
        this.jAl = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hoU != null) {
            if (!this.jAl) {
                this.hoU.a(this.hHG, this.frk, this.hIq, 2);
            } else {
                this.hoU.a(this.hHG, this.frk, this.hIq, 1);
            }
        }
    }
}
