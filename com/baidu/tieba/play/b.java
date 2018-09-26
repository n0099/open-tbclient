package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bzS;
    private int dtE;
    private boolean duj;
    private m dur;
    private boolean eYk = false;

    public b(m mVar) {
        this.dur = mVar;
    }

    public void gb(boolean z) {
        this.duj = z;
    }

    public void pJ(int i) {
        this.dtE = i;
    }

    public void pK(int i) {
        this.bzS = i;
    }

    public void iS(boolean z) {
        this.eYk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dur != null) {
            if (!this.eYk) {
                this.dur.a(this.dtE, this.bzS, this.duj, 2);
            } else {
                this.dur.a(this.dtE, this.bzS, this.duj, 1);
            }
        }
    }
}
