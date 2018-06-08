package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean gcn;
    private boolean gco;
    private Runnable gcp = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.gcn = false;
        }
    };
    private Runnable gcq = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.gco = false;
        }
    };

    public void onPrepared() {
        this.gco = true;
        com.baidu.adp.lib.g.e.im().postDelayed(this.gcq, 500L);
    }

    public void blI() {
        this.gcn = true;
    }

    public void blJ() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gcp);
        com.baidu.adp.lib.g.e.im().postDelayed(this.gcp, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.gcn && !this.gco) {
            iVar.aWM();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.gcn && !this.gco) {
            iVar.aWN();
            this.gcn = false;
            this.gco = false;
            blK();
        }
    }

    public void blK() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gcp);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gcq);
    }
}
