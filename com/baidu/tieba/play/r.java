package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean iyo;
    private boolean iyp;
    private Runnable iyq = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.iyo = false;
        }
    };
    private Runnable iyr = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.iyp = false;
        }
    };

    public void onPrepared() {
        this.iyp = true;
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iyr, 500L);
    }

    public void ccC() {
        this.iyo = true;
    }

    public void ccD() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyq);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iyq, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.iyo && !this.iyp) {
            iVar.bMI();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.iyo && !this.iyp) {
            iVar.bMJ();
            this.iyo = false;
            this.iyp = false;
            ccE();
        }
    }

    public void ccE() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyq);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iyr);
    }
}
