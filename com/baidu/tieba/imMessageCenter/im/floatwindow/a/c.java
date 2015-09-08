package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point bIh;
    private Point bIi;
    private Point bIj;
    private final int bIk;
    private final int bIl;
    private a bIm;
    private int bIn;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void XL();

        void a(Point point);
    }

    private int hA(int i) {
        return (int) (((this.k * i) + this.bIh.y) - (this.k * this.bIh.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.bIj.equals(this.bIi)) {
            switch (this.bIn) {
                case 0:
                    XS();
                    break;
                case 1:
                    XU();
                    break;
                case 2:
                    XT();
                    break;
                case 3:
                    XV();
                    break;
                case 4:
                    XW();
                    break;
                case 5:
                    XX();
                    break;
            }
            return false;
        }
        if (this.bIm != null) {
            this.bIm.XL();
        }
        return true;
    }

    private void XS() {
        this.bIj.y += this.bIl;
        if (this.bIj.y > this.bIi.y) {
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XT() {
        this.bIj.x += this.bIk;
        if (this.bIj.x > this.bIi.x) {
            this.bIj.x = this.bIi.x;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XU() {
        this.bIj.y -= this.bIl;
        if (this.bIj.y < this.bIi.y) {
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XV() {
        this.bIj.x -= this.bIk;
        if (this.bIj.x < this.bIi.x) {
            this.bIj.x = this.bIi.x;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XW() {
        this.bIj.x -= this.bIk;
        this.bIj.y = hA(this.bIj.x);
        if (this.bIj.x < this.bIi.x && this.bIj.y < this.bIi.y) {
            this.bIj.x = this.bIi.x;
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XX() {
        this.bIj.x += this.bIk;
        this.bIj.y = hA(this.bIj.x);
        if (this.bIj.x > this.bIi.x && this.bIj.y > this.bIi.y) {
            this.bIj.x = this.bIi.x;
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }
}
