package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int bIr;
    private int bIs;
    private a bIt;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void ev(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.bIs = i;
    }

    public void hB(int i) {
        this.bIr = i;
    }

    public void a(a aVar) {
        this.bIt = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.bIs != this.bIr) {
            if (this.bIr > this.start) {
                this.bIs += this.speed;
                if (this.bIs > this.bIr) {
                    this.bIs = this.bIr;
                }
            } else {
                this.bIs -= this.speed;
                if (this.bIs < this.bIr) {
                    this.bIs = this.bIr;
                }
            }
            if (this.bIt != null) {
                this.bIt.ev(this.bIs);
            }
            return false;
        }
        return true;
    }
}
