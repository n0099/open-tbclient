package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a bLC;
    private int bLD;
    private float bLE;
    private float bLF;
    private final long bLG;
    private float k;
    private long startTime;
    private Point bLx = new Point();
    private Point bLz = new Point();
    private Point bLy = new Point();

    public d(long j) {
        this.bLG = j;
    }

    public void a(c.a aVar) {
        this.bLC = aVar;
    }

    public void a(Point point, Point point2) {
        this.bLx.x = point.x;
        this.bLx.y = point.y;
        this.bLz.x = point.x;
        this.bLz.y = point.y;
        this.bLy.x = point2.x;
        this.bLy.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bLF = Math.abs(point2.y - point.y) / ((float) this.bLG);
            if (point2.y > point.y) {
                this.bLD = 0;
            } else {
                this.bLD = 1;
            }
        } else if (point.y == point2.y) {
            this.bLE = Math.abs(point2.x - point.x) / ((float) this.bLG);
            if (point2.x > point.x) {
                this.bLD = 2;
            } else {
                this.bLD = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bLE = Math.abs(f) / ((float) this.bLG);
            if (f > 0.0f) {
                this.bLD = 5;
            } else {
                this.bLD = 4;
            }
        }
    }

    private int hG(int i) {
        return (int) (((this.k * i) + this.bLx.y) - (this.k * this.bLx.x));
    }

    private long YC() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bLz.y = (int) (this.bLx.y + (this.bLF * ((float) YC())));
        if (this.bLz.y > this.bLy.y) {
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yx() {
        this.bLz.x = (int) (this.bLx.x + (this.bLE * ((float) YC())));
        if (this.bLz.x > this.bLy.x) {
            this.bLz.x = this.bLy.x;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yy() {
        this.bLz.y = (int) (this.bLx.y - (this.bLF * ((float) YC())));
        if (this.bLz.y < this.bLy.y) {
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void Yz() {
        this.bLz.x = (int) (this.bLx.x - (this.bLE * ((float) YC())));
        if (this.bLz.x < this.bLy.x) {
            this.bLz.x = this.bLy.x;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void YA() {
        boolean z = true;
        this.bLz.x = (int) (this.bLx.x - (this.bLE * ((float) YC())));
        this.bLz.y = hG(this.bLz.x);
        if (this.bLx.y <= this.bLy.y ? this.bLz.y <= this.bLy.y : this.bLz.y >= this.bLy.y) {
            z = false;
        }
        if (this.bLz.x < this.bLy.x || z) {
            this.bLz.x = this.bLy.x;
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }

    private void YB() {
        boolean z = true;
        this.bLz.x = (int) (this.bLx.x + (this.bLE * ((float) YC())));
        this.bLz.y = hG(this.bLz.x);
        if (this.bLx.y <= this.bLy.y ? this.bLz.y <= this.bLy.y : this.bLz.y >= this.bLy.y) {
            z = false;
        }
        if (this.bLz.x > this.bLy.x || z) {
            this.bLz.x = this.bLy.x;
            this.bLz.y = this.bLy.y;
        }
        if (this.bLC != null) {
            this.bLC.a(this.bLz);
        }
    }
}
