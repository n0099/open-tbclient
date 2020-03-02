package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jvV;
    private boolean jvW;
    private Runnable jvX = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jvV = false;
        }
    };
    private Runnable jvY = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jvW = false;
        }
    };

    public void onPrepared() {
        this.jvW = true;
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvY, 500L);
    }

    public void czd() {
        this.jvV = true;
    }

    public void cze() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvX);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jvX, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jvV && !this.jvW) {
            iVar.cgH();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jvV && !this.jvW) {
            iVar.cgI();
            this.jvV = false;
            this.jvW = false;
            Gm();
        }
    }

    public void Gm() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvX);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jvY);
    }
}
