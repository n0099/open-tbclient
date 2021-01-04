package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gAO;
    private i iOh;
    private int jhq;
    private boolean jia;
    private boolean kZi = false;

    public b(i iVar) {
        this.iOh = iVar;
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
        if (this.iOh != null) {
            if (!this.kZi) {
                this.iOh.a(this.jhq, this.gAO, this.jia, 2);
            } else {
                this.iOh.a(this.jhq, this.gAO, this.jia, 1);
            }
        }
    }
}
