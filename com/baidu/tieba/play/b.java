package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int brT;
    private int diQ;
    private m djB;
    private boolean djt;
    private boolean eJi = false;

    public b(m mVar) {
        this.djB = mVar;
    }

    public void fE(boolean z) {
        this.djt = z;
    }

    public void oJ(int i) {
        this.diQ = i;
    }

    public void oK(int i) {
        this.brT = i;
    }

    public void ih(boolean z) {
        this.eJi = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.djB != null) {
            if (!this.eJi) {
                this.djB.a(this.diQ, this.brT, this.djt, 2);
            } else {
                this.djB.a(this.diQ, this.brT, this.djt, 1);
            }
        }
    }
}
