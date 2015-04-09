package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e brd;
    private int bre;
    private float brf;
    private float brg;
    private final long brh;
    private float k;
    private long startTime;
    private Point bqY = new Point();
    private Point bra = new Point();
    private Point bqZ = new Point();

    public f(long j) {
        this.brh = j;
    }

    public void a(e eVar) {
        this.brd = eVar;
    }

    public void a(Point point, Point point2) {
        this.bqY.x = point.x;
        this.bqY.y = point.y;
        this.bra.x = point.x;
        this.bra.y = point.y;
        this.bqZ.x = point2.x;
        this.bqZ.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.brg = Math.abs(point2.y - point.y) / ((float) this.brh);
            if (point2.y > point.y) {
                this.bre = 0;
            } else {
                this.bre = 1;
            }
        } else if (point.y == point2.y) {
            this.brf = Math.abs(point2.x - point.x) / ((float) this.brh);
            if (point2.x > point.x) {
                this.bre = 2;
            } else {
                this.bre = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.brf = Math.abs(f) / ((float) this.brh);
            if (f > 0.0f) {
                this.bre = 5;
            } else {
                this.bre = 4;
            }
        }
    }

    private int gv(int i) {
        return (int) (((this.k * i) + this.bqY.y) - (this.k * this.bqY.x));
    }

    private long UX() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bra.y = (int) (this.bqY.y + (this.brg * ((float) UX())));
        if (this.bra.y > this.bqZ.y) {
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void US() {
        this.bra.x = (int) (this.bqY.x + (this.brf * ((float) UX())));
        if (this.bra.x > this.bqZ.x) {
            this.bra.x = this.bqZ.x;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UT() {
        this.bra.y = (int) (this.bqY.y - (this.brg * ((float) UX())));
        if (this.bra.y < this.bqZ.y) {
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UU() {
        this.bra.x = (int) (this.bqY.x - (this.brf * ((float) UX())));
        if (this.bra.x < this.bqZ.x) {
            this.bra.x = this.bqZ.x;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UV() {
        boolean z = true;
        this.bra.x = (int) (this.bqY.x - (this.brf * ((float) UX())));
        this.bra.y = gv(this.bra.x);
        if (this.bqY.y <= this.bqZ.y ? this.bra.y <= this.bqZ.y : this.bra.y >= this.bqZ.y) {
            z = false;
        }
        if (this.bra.x < this.bqZ.x || z) {
            this.bra.x = this.bqZ.x;
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }

    private void UW() {
        boolean z = true;
        this.bra.x = (int) (this.bqY.x + (this.brf * ((float) UX())));
        this.bra.y = gv(this.bra.x);
        if (this.bqY.y <= this.bqZ.y ? this.bra.y <= this.bqZ.y : this.bra.y >= this.bqZ.y) {
            z = false;
        }
        if (this.bra.x > this.bqZ.x || z) {
            this.bra.x = this.bqZ.x;
            this.bra.y = this.bqZ.y;
        }
        if (this.brd != null) {
            this.brd.a(this.bra);
        }
    }
}
