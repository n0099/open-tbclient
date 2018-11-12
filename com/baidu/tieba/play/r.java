package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean gxl;
    private boolean gxm;
    private Runnable gxn = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.gxl = false;
        }
    };
    private Runnable gxo = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.gxm = false;
        }
    };

    public void onPrepared() {
        this.gxm = true;
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gxo, 500L);
    }

    public void bpT() {
        this.gxl = true;
    }

    public void bpU() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gxn);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gxn, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gxl && !this.gxm) {
            iVar.baG();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gxl && !this.gxm) {
            iVar.baH();
            this.gxl = false;
            this.gxm = false;
            bpV();
        }
    }

    public void bpV() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gxn);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gxo);
    }
}
