package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int baJ;
    private boolean cdL;
    private ac cdS;
    private int cdm;
    private boolean dEA = false;

    public b(ac acVar) {
        this.cdS = acVar;
    }

    public void ez(boolean z) {
        this.cdL = z;
    }

    public void mV(int i) {
        this.cdm = i;
    }

    public void mW(int i) {
        this.baJ = i;
    }

    public void he(boolean z) {
        this.dEA = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cdS != null) {
            if (!this.dEA) {
                this.cdS.a(this.cdm, this.baJ, this.cdL, 2);
            } else {
                this.cdS.a(this.cdm, this.baJ, this.cdL, 1);
            }
        }
    }
}
