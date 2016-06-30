package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int daA;
    private a daB;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.daA = i;
    }

    public void lr(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.daB = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.daA != this.end) {
            if (this.end > this.start) {
                this.daA += this.speed;
                if (this.daA > this.end) {
                    this.daA = this.end;
                }
            } else {
                this.daA -= this.speed;
                if (this.daA < this.end) {
                    this.daA = this.end;
                }
            }
            if (this.daB != null) {
                this.daB.eN(this.daA);
            }
            return false;
        }
        return true;
    }
}
