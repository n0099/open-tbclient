package com.baidu.tieba.play;
/* loaded from: classes.dex */
public class q {
    private boolean goh;
    private boolean goi;
    private Runnable goj = new Runnable() { // from class: com.baidu.tieba.play.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.goh = false;
        }
    };
    private Runnable gok = new Runnable() { // from class: com.baidu.tieba.play.q.2
        @Override // java.lang.Runnable
        public void run() {
            q.this.goi = false;
        }
    };

    public void onPrepared() {
        this.goi = true;
        com.baidu.adp.lib.g.e.jt().postDelayed(this.gok, 500L);
    }

    public void bni() {
        this.goh = true;
    }

    public void bnj() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.goj);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.goj, 500L);
    }

    public void a(int i, int i2, com.baidu.tieba.j.i iVar) {
        if ((i == 701 || i2 == 701) && iVar != null && !this.goh && !this.goi) {
            iVar.aXW();
        } else if ((i == 702 || i2 == 702) && iVar != null && !this.goh && !this.goi) {
            iVar.aXX();
            this.goh = false;
            this.goi = false;
            bnk();
        }
    }

    public void bnk() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.goj);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gok);
    }
}
