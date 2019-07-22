package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean iwM;
    private boolean iwN;
    private Runnable iwO = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.iwM = false;
        }
    };
    private Runnable iwP = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.iwN = false;
        }
    };

    public void onPrepared() {
        this.iwN = true;
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iwP, 500L);
    }

    public void cev() {
        this.iwM = true;
    }

    public void cew() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwO);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iwO, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.iwM && !this.iwN) {
            iVar.bOH();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.iwM && !this.iwN) {
            iVar.bOI();
            this.iwM = false;
            this.iwN = false;
            cex();
        }
    }

    public void cex() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwO);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwP);
    }
}
