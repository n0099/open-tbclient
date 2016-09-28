package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point dqs;
    private Point dqt;
    private Point dqu;
    private final int dqv;
    private final int dqw;
    private a dqx;
    private int dqy;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void axX();
    }

    private int mh(int i) {
        return (int) (((this.k * i) + this.dqs.y) - (this.k * this.dqs.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.dqu.equals(this.dqt)) {
            switch (this.dqy) {
                case 0:
                    aye();
                    break;
                case 1:
                    ayg();
                    break;
                case 2:
                    ayf();
                    break;
                case 3:
                    ayh();
                    break;
                case 4:
                    ayi();
                    break;
                case 5:
                    ayj();
                    break;
            }
            return false;
        }
        if (this.dqx != null) {
            this.dqx.axX();
        }
        return true;
    }

    private void aye() {
        this.dqu.y += this.dqw;
        if (this.dqu.y > this.dqt.y) {
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayf() {
        this.dqu.x += this.dqv;
        if (this.dqu.x > this.dqt.x) {
            this.dqu.x = this.dqt.x;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayg() {
        this.dqu.y -= this.dqw;
        if (this.dqu.y < this.dqt.y) {
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayh() {
        this.dqu.x -= this.dqv;
        if (this.dqu.x < this.dqt.x) {
            this.dqu.x = this.dqt.x;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayi() {
        this.dqu.x -= this.dqv;
        this.dqu.y = mh(this.dqu.x);
        if (this.dqu.x < this.dqt.x && this.dqu.y < this.dqt.y) {
            this.dqu.x = this.dqt.x;
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayj() {
        this.dqu.x += this.dqv;
        this.dqu.y = mh(this.dqu.x);
        if (this.dqu.x > this.dqt.x && this.dqu.y > this.dqt.y) {
            this.dqu.x = this.dqt.x;
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }
}
