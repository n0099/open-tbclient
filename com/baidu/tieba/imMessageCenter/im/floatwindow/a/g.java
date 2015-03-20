package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int bqS;
    private int bqT;
    private h bqU;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.bqT = i;
    }

    public void gu(int i) {
        this.bqS = i;
    }

    public void a(h hVar) {
        this.bqU = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (this.bqT != this.bqS) {
            if (this.bqS > this.start) {
                this.bqT += this.speed;
                if (this.bqT > this.bqS) {
                    this.bqT = this.bqS;
                }
            } else {
                this.bqT -= this.speed;
                if (this.bqT < this.bqS) {
                    this.bqT = this.bqS;
                }
            }
            if (this.bqU != null) {
                this.bqU.dY(this.bqT);
            }
            return false;
        }
        return true;
    }
}
