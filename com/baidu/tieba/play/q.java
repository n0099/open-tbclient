package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean jrx;
    private boolean jry;
    private Runnable jrz = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.jrx = false;
        }
    };
    private Runnable jrA = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.jry = false;
        }
    };

    public void onPrepared() {
        this.jry = true;
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jrA, 500L);
    }

    public void cwy() {
        this.jrx = true;
    }

    public void cwz() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrz);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jrz, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.jrx && !this.jry) {
            iVar.cdS();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.jrx && !this.jry) {
            iVar.cdT();
            this.jrx = false;
            this.jry = false;
            Dz();
        }
    }

    public void Dz() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrz);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jrA);
    }
}
