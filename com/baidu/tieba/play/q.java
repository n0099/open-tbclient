package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean khF;
    private boolean khG;
    private Runnable khH = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.khF = false;
        }
    };
    private Runnable khI = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.khG = false;
        }
    };

    public void onPrepared() {
        this.khG = true;
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khI, 500L);
    }

    public void cKa() {
        this.khF = true;
    }

    public void cKb() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khH);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.khH, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.k.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.khF && !this.khG) {
            iVar.crH();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.khF && !this.khG) {
            iVar.crI();
            this.khF = false;
            this.khG = false;
            Od();
        }
    }

    public void Od() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khH);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.khI);
    }
}
