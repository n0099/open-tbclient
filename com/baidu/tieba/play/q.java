package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean fRb;
    private boolean fRc;
    private Runnable fRd = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.fRb = false;
        }
    };
    private Runnable fRe = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.fRc = false;
        }
    };

    public void onPrepared() {
        this.fRc = true;
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fRe, 500L);
    }

    public void bgK() {
        this.fRb = true;
    }

    public void bgL() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fRd);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fRd, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.fRb && !this.fRc) {
            iVar.aRP();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.fRb && !this.fRc) {
            iVar.aRQ();
            this.fRb = false;
            this.fRc = false;
            bgM();
        }
    }

    public void bgM() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fRd);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fRe);
    }
}
