package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class r {
    private boolean iqs;
    private boolean iqt;
    private Runnable iqu = new Runnable() { // from class: com.baidu.tieba.play.r.1
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqs = false;
        }
    };
    private Runnable iqv = new Runnable() { // from class: com.baidu.tieba.play.r.2
        @Override // java.lang.Runnable
        public void run() {
            r.this.iqt = false;
        }
    };

    public void onPrepared() {
        this.iqt = true;
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqv, 500L);
    }

    public void cbB() {
        this.iqs = true;
    }

    public void cbC() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqu);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iqu, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.iqs && !this.iqt) {
            iVar.bLV();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.iqs && !this.iqt) {
            iVar.bLW();
            this.iqs = false;
            this.iqt = false;
            cbD();
        }
    }

    public void cbD() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqu);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iqv);
    }
}
