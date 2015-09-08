package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a bIm;
    private int bIn;
    private float bIo;
    private float bIp;
    private final long bIq;
    private float k;
    private long startTime;
    private Point bIh = new Point();
    private Point bIj = new Point();
    private Point bIi = new Point();

    public d(long j) {
        this.bIq = j;
    }

    public void a(c.a aVar) {
        this.bIm = aVar;
    }

    public void a(Point point, Point point2) {
        this.bIh.x = point.x;
        this.bIh.y = point.y;
        this.bIj.x = point.x;
        this.bIj.y = point.y;
        this.bIi.x = point2.x;
        this.bIi.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bIp = Math.abs(point2.y - point.y) / ((float) this.bIq);
            if (point2.y > point.y) {
                this.bIn = 0;
            } else {
                this.bIn = 1;
            }
        } else if (point.y == point2.y) {
            this.bIo = Math.abs(point2.x - point.x) / ((float) this.bIq);
            if (point2.x > point.x) {
                this.bIn = 2;
            } else {
                this.bIn = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bIo = Math.abs(f) / ((float) this.bIq);
            if (f > 0.0f) {
                this.bIn = 5;
            } else {
                this.bIn = 4;
            }
        }
    }

    private int hA(int i) {
        return (int) (((this.k * i) + this.bIh.y) - (this.k * this.bIh.x));
    }

    private long XY() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bIj.y = (int) (this.bIh.y + (this.bIp * ((float) XY())));
        if (this.bIj.y > this.bIi.y) {
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XT() {
        this.bIj.x = (int) (this.bIh.x + (this.bIo * ((float) XY())));
        if (this.bIj.x > this.bIi.x) {
            this.bIj.x = this.bIi.x;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XU() {
        this.bIj.y = (int) (this.bIh.y - (this.bIp * ((float) XY())));
        if (this.bIj.y < this.bIi.y) {
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XV() {
        this.bIj.x = (int) (this.bIh.x - (this.bIo * ((float) XY())));
        if (this.bIj.x < this.bIi.x) {
            this.bIj.x = this.bIi.x;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XW() {
        boolean z = true;
        this.bIj.x = (int) (this.bIh.x - (this.bIo * ((float) XY())));
        this.bIj.y = hA(this.bIj.x);
        if (this.bIh.y <= this.bIi.y ? this.bIj.y <= this.bIi.y : this.bIj.y >= this.bIi.y) {
            z = false;
        }
        if (this.bIj.x < this.bIi.x || z) {
            this.bIj.x = this.bIi.x;
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }

    private void XX() {
        boolean z = true;
        this.bIj.x = (int) (this.bIh.x + (this.bIo * ((float) XY())));
        this.bIj.y = hA(this.bIj.x);
        if (this.bIh.y <= this.bIi.y ? this.bIj.y <= this.bIi.y : this.bIj.y >= this.bIi.y) {
            z = false;
        }
        if (this.bIj.x > this.bIi.x || z) {
            this.bIj.x = this.bIi.x;
            this.bIj.y = this.bIi.y;
        }
        if (this.bIm != null) {
            this.bIm.a(this.bIj);
        }
    }
}
