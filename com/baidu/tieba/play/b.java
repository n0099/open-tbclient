package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int dof;
    private int fxK;
    private boolean fyp;
    private m fyw;
    private boolean hie = false;

    public b(m mVar) {
        this.fyw = mVar;
    }

    public void kg(boolean z) {
        this.fyp = z;
    }

    public void wC(int i) {
        this.fxK = i;
    }

    public void wD(int i) {
        this.dof = i;
    }

    public void ni(boolean z) {
        this.hie = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.fyw != null) {
            if (!this.hie) {
                this.fyw.a(this.fxK, this.dof, this.fyp, 2);
            } else {
                this.fyw.a(this.fxK, this.dof, this.fyp, 1);
            }
        }
    }
}
