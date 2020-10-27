package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gch;
    private int iDz;
    private boolean iEj;
    private i iko;
    private boolean kAb = false;

    public b(i iVar) {
        this.iko = iVar;
    }

    public void px(boolean z) {
        this.iEj = z;
    }

    public void DQ(int i) {
        this.iDz = i;
    }

    public void DR(int i) {
        this.gch = i;
    }

    public void sM(boolean z) {
        this.kAb = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iko != null) {
            if (!this.kAb) {
                this.iko.a(this.iDz, this.gch, this.iEj, 2);
            } else {
                this.iko.a(this.iDz, this.gch, this.iEj, 1);
            }
        }
    }
}
