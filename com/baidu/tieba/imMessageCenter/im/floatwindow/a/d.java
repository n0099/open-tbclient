package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a ddr;
    private int dds;
    private float ddt;
    private float ddv;
    private final long ddw;
    private float k;
    private long startTime;
    private Point ddm = new Point();
    private Point ddo = new Point();
    private Point ddn = new Point();

    public d(long j) {
        this.ddw = j;
    }

    public void a(c.a aVar) {
        this.ddr = aVar;
    }

    public void a(Point point, Point point2) {
        this.ddm.x = point.x;
        this.ddm.y = point.y;
        this.ddo.x = point.x;
        this.ddo.y = point.y;
        this.ddn.x = point2.x;
        this.ddn.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.ddv = Math.abs(point2.y - point.y) / ((float) this.ddw);
            if (point2.y > point.y) {
                this.dds = 0;
            } else {
                this.dds = 1;
            }
        } else if (point.y == point2.y) {
            this.ddt = Math.abs(point2.x - point.x) / ((float) this.ddw);
            if (point2.x > point.x) {
                this.dds = 2;
            } else {
                this.dds = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.ddt = Math.abs(f) / ((float) this.ddw);
            if (f > 0.0f) {
                this.dds = 5;
            } else {
                this.dds = 4;
            }
        }
    }

    private int lw(int i) {
        return (int) (((this.k * i) + this.ddm.y) - (this.k * this.ddm.x));
    }

    private long asX() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.ddo.y = (int) (this.ddm.y + (this.ddv * ((float) asX())));
        if (this.ddo.y > this.ddn.y) {
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asS() {
        this.ddo.x = (int) (this.ddm.x + (this.ddt * ((float) asX())));
        if (this.ddo.x > this.ddn.x) {
            this.ddo.x = this.ddn.x;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asT() {
        this.ddo.y = (int) (this.ddm.y - (this.ddv * ((float) asX())));
        if (this.ddo.y < this.ddn.y) {
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asU() {
        this.ddo.x = (int) (this.ddm.x - (this.ddt * ((float) asX())));
        if (this.ddo.x < this.ddn.x) {
            this.ddo.x = this.ddn.x;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asV() {
        boolean z = true;
        this.ddo.x = (int) (this.ddm.x - (this.ddt * ((float) asX())));
        this.ddo.y = lw(this.ddo.x);
        if (this.ddm.y <= this.ddn.y ? this.ddo.y <= this.ddn.y : this.ddo.y >= this.ddn.y) {
            z = false;
        }
        if (this.ddo.x < this.ddn.x || z) {
            this.ddo.x = this.ddn.x;
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }

    private void asW() {
        boolean z = true;
        this.ddo.x = (int) (this.ddm.x + (this.ddt * ((float) asX())));
        this.ddo.y = lw(this.ddo.x);
        if (this.ddm.y <= this.ddn.y ? this.ddo.y <= this.ddn.y : this.ddo.y >= this.ddn.y) {
            z = false;
        }
        if (this.ddo.x > this.ddn.x || z) {
            this.ddo.x = this.ddn.x;
            this.ddo.y = this.ddn.y;
        }
        if (this.ddr != null) {
            this.ddr.a(this.ddo);
        }
    }
}
