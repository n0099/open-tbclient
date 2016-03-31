package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int cul;
    private a cum;
    private int end;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void fe(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.cul = i;
    }

    public void kl(int i) {
        this.end = i;
    }

    public void a(a aVar) {
        this.cum = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.cul != this.end) {
            if (this.end > this.start) {
                this.cul += this.speed;
                if (this.cul > this.end) {
                    this.cul = this.end;
                }
            } else {
                this.cul -= this.speed;
                if (this.cul < this.end) {
                    this.cul = this.end;
                }
            }
            if (this.cum != null) {
                this.cum.fe(this.cul);
            }
            return false;
        }
        return true;
    }
}
