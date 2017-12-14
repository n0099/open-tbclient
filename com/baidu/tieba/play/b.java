package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bjV;
    private boolean cIN;
    private m cIV;
    private int cIp;
    private boolean eiD = false;

    public b(m mVar) {
        this.cIV = mVar;
    }

    public void eY(boolean z) {
        this.cIN = z;
    }

    public void on(int i) {
        this.cIp = i;
    }

    public void oo(int i) {
        this.bjV = i;
    }

    public void hH(boolean z) {
        this.eiD = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cIV != null) {
            if (!this.eiD) {
                this.cIV.a(this.cIp, this.bjV, this.cIN, 2);
            } else {
                this.cIV.a(this.cIp, this.bjV, this.cIN, 1);
            }
        }
    }
}
