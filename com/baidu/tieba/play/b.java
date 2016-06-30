package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class b implements Runnable {
    private f aIG;
    private boolean aKt;
    private int aKx;
    private int aKy;
    private boolean eDv = false;

    public b(f fVar) {
        this.aIG = fVar;
    }

    public void dr(boolean z) {
        this.aKt = z;
    }

    public void pv(int i) {
        this.aKy = i;
    }

    public void pw(int i) {
        this.aKx = i;
    }

    public void jz(boolean z) {
        this.eDv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aIG != null) {
            if (!this.eDv) {
                this.aIG.a(this.aKy, this.aKx, this.aKt, 2);
            }
            this.aIG.a(this.aKy, this.aKx, this.aKt, 1);
        }
    }
}
