package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a cjB;
    private int cjC;
    private float cjD;
    private float cjE;
    private final long cjF;
    private float k;
    private long startTime;
    private Point cjw = new Point();
    private Point cjy = new Point();
    private Point cjx = new Point();

    public d(long j) {
        this.cjF = j;
    }

    public void a(c.a aVar) {
        this.cjB = aVar;
    }

    public void a(Point point, Point point2) {
        this.cjw.x = point.x;
        this.cjw.y = point.y;
        this.cjy.x = point.x;
        this.cjy.y = point.y;
        this.cjx.x = point2.x;
        this.cjx.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.cjE = Math.abs(point2.y - point.y) / ((float) this.cjF);
            if (point2.y > point.y) {
                this.cjC = 0;
            } else {
                this.cjC = 1;
            }
        } else if (point.y == point2.y) {
            this.cjD = Math.abs(point2.x - point.x) / ((float) this.cjF);
            if (point2.x > point.x) {
                this.cjC = 2;
            } else {
                this.cjC = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.cjD = Math.abs(f) / ((float) this.cjF);
            if (f > 0.0f) {
                this.cjC = 5;
            } else {
                this.cjC = 4;
            }
        }
    }

    private int jE(int i) {
        return (int) (((this.k * i) + this.cjw.y) - (this.k * this.cjw.x));
    }

    private long agv() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.cjy.equals(this.cjx)) {
            switch (this.cjC) {
                case 0:
                    agp();
                    break;
                case 1:
                    agr();
                    break;
                case 2:
                    agq();
                    break;
                case 3:
                    ags();
                    break;
                case 4:
                    agt();
                    break;
                case 5:
                    agu();
                    break;
            }
            return false;
        }
        if (this.cjB != null) {
            this.cjB.agi();
        }
        return true;
    }

    private void agp() {
        this.cjy.y = (int) (this.cjw.y + (this.cjE * ((float) agv())));
        if (this.cjy.y > this.cjx.y) {
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agq() {
        this.cjy.x = (int) (this.cjw.x + (this.cjD * ((float) agv())));
        if (this.cjy.x > this.cjx.x) {
            this.cjy.x = this.cjx.x;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agr() {
        this.cjy.y = (int) (this.cjw.y - (this.cjE * ((float) agv())));
        if (this.cjy.y < this.cjx.y) {
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void ags() {
        this.cjy.x = (int) (this.cjw.x - (this.cjD * ((float) agv())));
        if (this.cjy.x < this.cjx.x) {
            this.cjy.x = this.cjx.x;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agt() {
        boolean z = true;
        this.cjy.x = (int) (this.cjw.x - (this.cjD * ((float) agv())));
        this.cjy.y = jE(this.cjy.x);
        if (this.cjw.y <= this.cjx.y ? this.cjy.y <= this.cjx.y : this.cjy.y >= this.cjx.y) {
            z = false;
        }
        if (this.cjy.x < this.cjx.x || z) {
            this.cjy.x = this.cjx.x;
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }

    private void agu() {
        boolean z = true;
        this.cjy.x = (int) (this.cjw.x + (this.cjD * ((float) agv())));
        this.cjy.y = jE(this.cjy.x);
        if (this.cjw.y <= this.cjx.y ? this.cjy.y <= this.cjx.y : this.cjy.y >= this.cjx.y) {
            z = false;
        }
        if (this.cjy.x > this.cjx.x || z) {
            this.cjy.x = this.cjx.x;
            this.cjy.y = this.cjx.y;
        }
        if (this.cjB != null) {
            this.cjB.a(this.cjy);
        }
    }
}
