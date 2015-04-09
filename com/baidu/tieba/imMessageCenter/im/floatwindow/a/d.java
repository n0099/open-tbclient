package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point bqY;
    private Point bqZ;
    private Point bra;
    private final int brb;
    private final int brc;
    private e brd;
    private int bre;
    private float k;

    private int gv(int i) {
        return (int) (((this.k * i) + this.bqY.y) - (this.k * this.bqY.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.bra.equals(this.bqZ)) {
            switch (this.bre) {
                case 0:
                    UR();
                    break;
                case 1:
                    UT();
                    break;
                case 2:
                    US();
                    break;
                case 3:
                    UU();
                    break;
                case 4:
                    UV();
                    break;
                case 5:
                    UW();
                    break;
            }
            return false;
        }
        if (this.brd != null) {
            this.brd.UK();
        }
        return true;
    }

    private void UR() {
        this.bra.y += this.brc;
        if (this.bra.y > this.bqZ.y) {
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void US() {
        this.bra.x += this.brb;
        if (this.bra.x > this.bqZ.x) {
            this.bra.x = this.bqZ.x;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UT() {
        this.bra.y -= this.brc;
        if (this.bra.y < this.bqZ.y) {
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UU() {
        this.bra.x -= this.brb;
        if (this.bra.x < this.bqZ.x) {
            this.bra.x = this.bqZ.x;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UV() {
        this.bra.x -= this.brb;
        this.bra.y = gv(this.bra.x);
        if (this.bra.x < this.bqZ.x && this.bra.y < this.bqZ.y) {
            this.bra.x = this.bqZ.x;
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UW() {
        this.bra.x += this.brb;
        this.bra.y = gv(this.bra.x);
        if (this.bra.x > this.bqZ.x && this.bra.y > this.bqZ.y) {
            this.bra.x = this.bqZ.x;
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }
}
