package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dkC;
    private int fqz;
    private boolean fre;
    private m frl;
    private boolean gZb = false;

    public b(m mVar) {
        this.frl = mVar;
    }

    public void jT(boolean z) {
        this.fre = z;
    }

    public void vV(int i) {
        this.fqz = i;
    }

    public void vW(int i) {
        this.dkC = i;
    }

    public void mQ(boolean z) {
        this.gZb = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.frl != null) {
            if (!this.gZb) {
                this.frl.a(this.fqz, this.dkC, this.fre, 2);
            } else {
                this.frl.a(this.fqz, this.dkC, this.fre, 1);
            }
        }
    }
}
