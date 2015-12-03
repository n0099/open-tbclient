package com.baidu.tieba.imMessageCenter.im.floatwindow.a;
/* loaded from: classes.dex */
public class e implements b {
    private int cbg;
    private int cbh;
    private a cbi;
    private final int speed;
    private int start;

    /* loaded from: classes.dex */
    public interface a {
        void eI(int i);
    }

    public e(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.cbh = i;
    }

    public void iI(int i) {
        this.cbg = i;
    }

    public void a(a aVar) {
        this.cbi = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (this.cbh != this.cbg) {
            if (this.cbg > this.start) {
                this.cbh += this.speed;
                if (this.cbh > this.cbg) {
                    this.cbh = this.cbg;
                }
            } else {
                this.cbh -= this.speed;
                if (this.cbh < this.cbg) {
                    this.cbh = this.cbg;
                }
            }
            if (this.cbi != null) {
                this.cbi.eI(this.cbh);
            }
            return false;
        }
        return true;
    }
}
