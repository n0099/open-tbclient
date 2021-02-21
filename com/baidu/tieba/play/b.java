package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gzf;
    private i iPw;
    private int jiE;
    private boolean jjo;
    private boolean lcV = false;

    public b(i iVar) {
        this.iPw = iVar;
    }

    public void qK(boolean z) {
        this.jjo = z;
    }

    public void DW(int i) {
        this.jiE = i;
    }

    public void DX(int i) {
        this.gzf = i;
    }

    public void tK(boolean z) {
        this.lcV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iPw != null) {
            if (!this.lcV) {
                this.iPw.a(this.jiE, this.gzf, this.jjo, 2);
            } else {
                this.iPw.a(this.jiE, this.gzf, this.jjo, 1);
            }
        }
    }
}
