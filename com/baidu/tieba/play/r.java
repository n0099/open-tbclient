package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gvm;
    private boolean gvn;
    private Runnable gvo = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvm = false;
        }
    };
    private Runnable gvp = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gvn = false;
        }
    };

    public void onPrepared() {
        this.gvn = true;
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gvp, 500L);
    }

    public void blE() {
        this.gvm = true;
    }

    public void blF() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvo);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gvo, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.i.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gvm && !this.gvn) {
            iVar.aWU();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gvm && !this.gvn) {
            iVar.aWV();
            this.gvm = false;
            this.gvn = false;
            blG();
        }
    }

    public void blG() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvo);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gvp);
    }
}
