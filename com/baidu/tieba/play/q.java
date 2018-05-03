package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean fPV;
    private boolean fPW;
    private Runnable fPX = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.fPV = false;
        }
    };
    private Runnable fPY = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.fPW = false;
        }
    };

    public void onPrepared() {
        this.fPW = true;
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPY, 500L);
    }

    public void bgK() {
        this.fPV = true;
    }

    public void bgL() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPX);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPX, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.fPV && !this.fPW) {
            iVar.aRP();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.fPV && !this.fPW) {
            iVar.aRQ();
            this.fPV = false;
            this.fPW = false;
            bgM();
        }
    }

    public void bgM() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPX);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPY);
    }
}
