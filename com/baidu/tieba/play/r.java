package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gvh;
    private boolean gvi;
    private Runnable gvj = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvh = false;
        }
    };
    private Runnable gvk = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvi = false;
        }
    };

    public void onPrepared() {
        this.gvi = true;
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gvk, 500L);
    }

    public void blE() {
        this.gvh = true;
    }

    public void blF() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvj);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gvj, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gvh && !this.gvi) {
            iVar.aWU();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gvh && !this.gvi) {
            iVar.aWV();
            this.gvh = false;
            this.gvi = false;
            blG();
        }
    }

    public void blG() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvj);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvk);
    }
}
