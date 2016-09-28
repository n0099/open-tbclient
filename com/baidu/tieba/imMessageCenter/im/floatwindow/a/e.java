package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int dqC;
    private a dqD;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void fa(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.dqC = i;
    }

    public void mi(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.dqD = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.dqC != this.end) {
            if (this.end > this.start) {
                this.dqC += this.speed;
                if (this.dqC > this.end) {
                    this.dqC = this.end;
                }
            } else {
                this.dqC -= this.speed;
                if (this.dqC < this.end) {
                    this.dqC = this.end;
                }
            }
            if (this.dqD != null) {
                this.dqD.fa(this.dqC);
            }
            return false;
        }
        return true;
    }
}
