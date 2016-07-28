package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point ddm;
    private Point ddn;
    private Point ddo;
    private final int ddp;
    private final int ddq;
    private a ddr;
    private int dds;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void asK();
    }

    private int lw(int i) {
        return (int) (((this.k * i) + this.ddm.y) - (this.k * this.ddm.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.ddo.equals(this.ddn)) {
            switch (this.dds) {
                case 0:
                    asR();
                    break;
                case 1:
                    asT();
                    break;
                case 2:
                    asS();
                    break;
                case 3:
                    asU();
                    break;
                case 4:
                    asV();
                    break;
                case 5:
                    asW();
                    break;
            }
            return false;
        }
        if (this.ddr != null) {
            this.ddr.asK();
        }
        return true;
    }

    private void asR() {
        this.ddo.y += this.ddq;
        if (this.ddo.y > this.ddn.y) {
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asS() {
        this.ddo.x += this.ddp;
        if (this.ddo.x > this.ddn.x) {
            this.ddo.x = this.ddn.x;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asT() {
        this.ddo.y -= this.ddq;
        if (this.ddo.y < this.ddn.y) {
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asU() {
        this.ddo.x -= this.ddp;
        if (this.ddo.x < this.ddn.x) {
            this.ddo.x = this.ddn.x;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asV() {
        this.ddo.x -= this.ddp;
        this.ddo.y = lw(this.ddo.x);
        if (this.ddo.x < this.ddn.x && this.ddo.y < this.ddn.y) {
            this.ddo.x = this.ddn.x;
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asW() {
        this.ddo.x += this.ddp;
        this.ddo.y = lw(this.ddo.x);
        if (this.ddo.x > this.ddn.x && this.ddo.y > this.ddn.y) {
            this.ddo.x = this.ddn.x;
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }
}
