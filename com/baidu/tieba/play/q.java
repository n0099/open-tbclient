package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean fPY;
    private boolean fPZ;
    private Runnable fQa = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.fPY = false;
        }
    };
    private Runnable fQb = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.fPZ = false;
        }
    };

    public void onPrepared() {
        this.fPZ = true;
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fQb, 500L);
    }

    public void bgK() {
        this.fPY = true;
    }

    public void bgL() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQa);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fQa, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.fPY && !this.fPZ) {
            iVar.aRP();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.fPY && !this.fPZ) {
            iVar.aRQ();
            this.fPY = false;
            this.fPZ = false;
            bgM();
        }
    }

    public void bgM() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQa);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fQb);
    }
}
