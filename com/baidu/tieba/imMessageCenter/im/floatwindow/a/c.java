package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private final int bLA;
    private final int bLB;
    private a bLC;
    private int bLD;
    private Point bLx;
    private Point bLy;
    private Point bLz;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void Yp();

        void a(Point point);
    }

    private int hG(int i) {
        return (int) (((this.k * i) + this.bLx.y) - (this.k * this.bLx.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.bLz.equals(this.bLy)) {
            switch (this.bLD) {
                case 0:
                    Yw();
                    break;
                case 1:
                    Yy();
                    break;
                case 2:
                    Yx();
                    break;
                case 3:
                    Yz();
                    break;
                case 4:
                    YA();
                    break;
                case 5:
                    YB();
                    break;
            }
            return false;
        }
        if (this.bLC != null) {
            this.bLC.Yp();
        }
        return true;
    }

    private void Yw() {
        this.bLz.y += this.bLB;
        if (this.bLz.y > this.bLy.y) {
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yx() {
        this.bLz.x += this.bLA;
        if (this.bLz.x > this.bLy.x) {
            this.bLz.x = this.bLy.x;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yy() {
        this.bLz.y -= this.bLB;
        if (this.bLz.y < this.bLy.y) {
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yz() {
        this.bLz.x -= this.bLA;
        if (this.bLz.x < this.bLy.x) {
            this.bLz.x = this.bLy.x;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void YA() {
        this.bLz.x -= this.bLA;
        this.bLz.y = hG(this.bLz.x);
        if (this.bLz.x < this.bLy.x && this.bLz.y < this.bLy.y) {
            this.bLz.x = this.bLy.x;
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void YB() {
        this.bLz.x += this.bLA;
        this.bLz.y = hG(this.bLz.x);
        if (this.bLz.x > this.bLy.x && this.bLz.y > this.bLy.y) {
            this.bLz.x = this.bLy.x;
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }
}
