package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private final int cjA;
    private a cjB;
    private int cjC;
    private Point cjw;
    private Point cjx;
    private Point cjy;
    private final int cjz;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void agi();
    }

    private int jE(int i) {
        return (int) (((this.k * i) + this.cjw.y) - (this.k * this.cjw.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.cjy.equals(this.cjx)) {
            switch (this.cjC) {
                case 0:
                    agp();
                    break;
                case 1:
                    agr();
                    break;
                case 2:
                    agq();
                    break;
                case 3:
                    ags();
                    break;
                case 4:
                    agt();
                    break;
                case 5:
                    agu();
                    break;
            }
            return false;
        }
        if (this.cjB != null) {
            this.cjB.agi();
        }
        return true;
    }

    private void agp() {
        this.cjy.y += this.cjA;
        if (this.cjy.y > this.cjx.y) {
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agq() {
        this.cjy.x += this.cjz;
        if (this.cjy.x > this.cjx.x) {
            this.cjy.x = this.cjx.x;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agr() {
        this.cjy.y -= this.cjA;
        if (this.cjy.y < this.cjx.y) {
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void ags() {
        this.cjy.x -= this.cjz;
        if (this.cjy.x < this.cjx.x) {
            this.cjy.x = this.cjx.x;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agt() {
        this.cjy.x -= this.cjz;
        this.cjy.y = jE(this.cjy.x);
        if (this.cjy.x < this.cjx.x && this.cjy.y < this.cjx.y) {
            this.cjy.x = this.cjx.x;
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agu() {
        this.cjy.x += this.cjz;
        this.cjy.y = jE(this.cjy.x);
        if (this.cjy.x > this.cjx.x && this.cjy.y > this.cjx.y) {
            this.cjy.x = this.cjx.x;
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }
}
