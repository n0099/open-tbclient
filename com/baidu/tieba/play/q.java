package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean ggo;
    private boolean ggp;
    private Runnable ggq = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggo = false;
        }
    };
    private Runnable ggr = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.ggp = false;
        }
    };

    public void onPrepared() {
        this.ggp = true;
        com.baidu.adp.lib.g.e.im().postDelayed(this.ggr, 500L);
    }

    public void bmm() {
        this.ggo = true;
    }

    public void bmn() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggq);
        com.baidu.adp.lib.g.e.im().postDelayed(this.ggq, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.ggo && !this.ggp) {
            iVar.aXt();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.ggo && !this.ggp) {
            iVar.aXu();
            this.ggo = false;
            this.ggp = false;
            bmo();
        }
    }

    public void bmo() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggq);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ggr);
    }
}
