package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean hYf;
    private boolean hYg;
    private Runnable hYh = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.hYf = false;
        }
    };
    private Runnable hYi = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.hYg = false;
        }
    };

    public void onPrepared() {
        this.hYg = true;
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYi, 500L);
    }

    public void bTC() {
        this.hYf = true;
    }

    public void bTD() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYh);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hYh, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.hYf && !this.hYg) {
            iVar.bEo();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.hYf && !this.hYg) {
            iVar.bEp();
            this.hYf = false;
            this.hYg = false;
            bTE();
        }
    }

    public void bTE() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYh);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hYi);
    }
}
