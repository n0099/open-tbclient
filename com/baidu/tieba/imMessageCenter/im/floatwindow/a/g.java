package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int btS;
    private int btT;
    private h btU;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.btT = i;
    }

    public void gN(int i) {
        this.btS = i;
    }

    public void a(h hVar) {
        this.btU = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (this.btT != this.btS) {
            if (this.btS > this.start) {
                this.btT += this.speed;
                if (this.btT > this.btS) {
                    this.btT = this.btS;
                }
            } else {
                this.btT -= this.speed;
                if (this.btT < this.btS) {
                    this.btT = this.btS;
                }
            }
            if (this.btU != null) {
                this.btU.ei(this.btT);
            }
            return false;
        }
        return true;
    }
}
