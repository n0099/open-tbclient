package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private int gyR;
    private i iPi;
    private int jiq;
    private boolean jja;
    private boolean lcH = false;

    public b(i iVar) {
        this.iPi = iVar;
    }

    public void qK(boolean z) {
        this.jja = z;
    }

    public void DW(int i) {
        this.jiq = i;
    }

    public void DX(int i) {
        this.gyR = i;
    }

    public void tK(boolean z) {
        this.lcH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.iPi != null) {
            if (!this.lcH) {
                this.iPi.a(this.jiq, this.gyR, this.jja, 2);
            } else {
                this.iPi.a(this.jiq, this.gyR, this.jja, 1);
            }
        }
    }
}
