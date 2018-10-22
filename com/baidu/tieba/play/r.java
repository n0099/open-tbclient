package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gvK;
    private boolean gvL;
    private Runnable gvM = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvK = false;
        }
    };
    private Runnable gvN = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvL = false;
        }
    };

    public void onPrepared() {
        this.gvL = true;
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvN, 500L);
    }

    public void bqx() {
        this.gvK = true;
    }

    public void bqy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvM);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvM, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gvK && !this.gvL) {
            iVar.bbj();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gvK && !this.gvL) {
            iVar.bbk();
            this.gvK = false;
            this.gvL = false;
            bqz();
        }
    }

    public void bqz() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvM);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvN);
    }
}
