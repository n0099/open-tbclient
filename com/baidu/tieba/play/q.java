package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jvT;
    private boolean jvU;
    private Runnable jvV = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jvT = false;
        }
    };
    private Runnable jvW = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jvU = false;
        }
    };

    public void onPrepared() {
        this.jvU = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvW, 500L);
    }

    public void czb() {
        this.jvT = true;
    }

    public void czc() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvV);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvV, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jvT && !this.jvU) {
            iVar.cgF();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jvT && !this.jvU) {
            iVar.cgG();
            this.jvT = false;
            this.jvU = false;
            Gk();
        }
    }

    public void Gk() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvV);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvW);
    }
}
