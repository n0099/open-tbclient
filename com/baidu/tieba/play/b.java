package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int bJl;
    private int dCW;
    private boolean dDB;
    private m dDJ;
    private boolean fhl = false;

    public b(m mVar) {
        this.dDJ = mVar;
    }

    public void gD(boolean z) {
        this.dDB = z;
    }

    public void qA(int i) {
        this.dCW = i;
    }

    public void qB(int i) {
        this.bJl = i;
    }

    public void ju(boolean z) {
        this.fhl = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dDJ != null) {
            if (!this.fhl) {
                this.dDJ.a(this.dCW, this.bJl, this.dDB, 2);
            } else {
                this.dDJ.a(this.dCW, this.bJl, this.dDB, 1);
            }
        }
    }
}
