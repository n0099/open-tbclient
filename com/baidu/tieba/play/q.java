package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean ggO;
    private boolean ggP;
    private Runnable ggQ = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggO = false;
        }
    };
    private Runnable ggR = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggP = false;
        }
    };

    public void onPrepared() {
        this.ggP = true;
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggR, 500L);
    }

    public void bkF() {
        this.ggO = true;
    }

    public void bkG() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggQ);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggQ, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.ggO && !this.ggP) {
            iVar.aVM();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.ggO && !this.ggP) {
            iVar.aVN();
            this.ggO = false;
            this.ggP = false;
            bkH();
        }
    }

    public void bkH() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggQ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggR);
    }
}
