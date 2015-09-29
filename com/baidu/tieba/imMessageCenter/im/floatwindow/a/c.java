package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point bLm;
    private Point bLn;
    private Point bLo;
    private final int bLp;
    private final int bLq;
    private a bLr;
    private int bLs;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void Yt();

        void a(Point point);
    }

    private int hG(int i) {
        return (int) (((this.k * i) + this.bLm.y) - (this.k * this.bLm.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.bLo.equals(this.bLn)) {
            switch (this.bLs) {
                case 0:
                    YA();
                    break;
                case 1:
                    YC();
                    break;
                case 2:
                    YB();
                    break;
                case 3:
                    YD();
                    break;
                case 4:
                    YE();
                    break;
                case 5:
                    YF();
                    break;
            }
            return false;
        }
        if (this.bLr != null) {
            this.bLr.Yt();
        }
        return true;
    }

    private void YA() {
        this.bLo.y += this.bLq;
        if (this.bLo.y > this.bLn.y) {
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YB() {
        this.bLo.x += this.bLp;
        if (this.bLo.x > this.bLn.x) {
            this.bLo.x = this.bLn.x;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YC() {
        this.bLo.y -= this.bLq;
        if (this.bLo.y < this.bLn.y) {
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YD() {
        this.bLo.x -= this.bLp;
        if (this.bLo.x < this.bLn.x) {
            this.bLo.x = this.bLn.x;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YE() {
        this.bLo.x -= this.bLp;
        this.bLo.y = hG(this.bLo.x);
        if (this.bLo.x < this.bLn.x && this.bLo.y < this.bLn.y) {
            this.bLo.x = this.bLn.x;
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YF() {
        this.bLo.x += this.bLp;
        this.bLo.y = hG(this.bLo.x);
        if (this.bLo.x > this.bLn.x && this.bLo.y > this.bLn.y) {
            this.bLo.x = this.bLn.x;
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }
}
