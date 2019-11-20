package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean ixx;
    private boolean ixy;
    private Runnable ixz = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.ixx = false;
        }
    };
    private Runnable ixA = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.ixy = false;
        }
    };

    public void onPrepared() {
        this.ixy = true;
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixA, 500L);
    }

    public void ccA() {
        this.ixx = true;
    }

    public void ccB() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixz);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ixz, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.ixx && !this.ixy) {
            iVar.bMG();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.ixx && !this.ixy) {
            iVar.bMH();
            this.ixx = false;
            this.ixy = false;
            ccC();
        }
    }

    public void ccC() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixz);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ixA);
    }
}
