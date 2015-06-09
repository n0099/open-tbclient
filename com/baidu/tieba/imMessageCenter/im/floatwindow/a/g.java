package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int btT;
    private int btU;
    private h btV;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.btU = i;
    }

    public void gN(int i) {
        this.btT = i;
    }

    public void a(h hVar) {
        this.btV = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (this.btU != this.btT) {
            if (this.btT > this.start) {
                this.btU += this.speed;
                if (this.btU > this.btT) {
                    this.btU = this.btT;
                }
            } else {
                this.btU -= this.speed;
                if (this.btU < this.btT) {
                    this.btU = this.btT;
                }
            }
            if (this.btV != null) {
                this.btV.ei(this.btU);
            }
            return false;
        }
        return true;
    }
}
