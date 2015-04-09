package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int bri;
    private int brj;
    private h brk;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.brj = i;
    }

    public void gw(int i) {
        this.bri = i;
    }

    public void a(h hVar) {
        this.brk = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (this.brj != this.bri) {
            if (this.bri > this.start) {
                this.brj += this.speed;
                if (this.brj > this.bri) {
                    this.brj = this.bri;
                }
            } else {
                this.brj -= this.speed;
                if (this.brj < this.bri) {
                    this.brj = this.bri;
                }
            }
            if (this.brk != null) {
                this.brk.dY(this.brj);
            }
            return false;
        }
        return true;
    }
}
