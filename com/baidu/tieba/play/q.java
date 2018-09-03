package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean ggN;
    private boolean ggO;
    private Runnable ggP = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggN = false;
        }
    };
    private Runnable ggQ = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggO = false;
        }
    };

    public void onPrepared() {
        this.ggO = true;
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggQ, 500L);
    }

    public void bkC() {
        this.ggN = true;
    }

    public void bkD() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggP);
        com.baidu.adp.lib.g.e.in().postDelayed(this.ggP, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.ggN && !this.ggO) {
            iVar.aVI();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.ggN && !this.ggO) {
            iVar.aVJ();
            this.ggN = false;
            this.ggO = false;
            bkE();
        }
    }

    public void bkE() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggP);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.ggQ);
    }
}
