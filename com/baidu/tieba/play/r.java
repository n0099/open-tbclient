package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gvJ;
    private boolean gvK;
    private Runnable gvL = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvJ = false;
        }
    };
    private Runnable gvM = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvK = false;
        }
    };

    public void onPrepared() {
        this.gvK = true;
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvM, 500L);
    }

    public void bqx() {
        this.gvJ = true;
    }

    public void bqy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvL);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.gvL, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gvJ && !this.gvK) {
            iVar.bbj();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gvJ && !this.gvK) {
            iVar.bbk();
            this.gvJ = false;
            this.gvK = false;
            bqz();
        }
    }

    public void bqz() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvL);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gvM);
    }
}
