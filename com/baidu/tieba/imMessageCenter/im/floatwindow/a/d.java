package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a bLr;
    private int bLs;
    private float bLt;
    private float bLu;
    private final long bLv;
    private float k;
    private long startTime;
    private Point bLm = new Point();
    private Point bLo = new Point();
    private Point bLn = new Point();

    public d(long j) {
        this.bLv = j;
    }

    public void a(c.a aVar) {
        this.bLr = aVar;
    }

    public void a(Point point, Point point2) {
        this.bLm.x = point.x;
        this.bLm.y = point.y;
        this.bLo.x = point.x;
        this.bLo.y = point.y;
        this.bLn.x = point2.x;
        this.bLn.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.bLu = Math.abs(point2.y - point.y) / ((float) this.bLv);
            if (point2.y > point.y) {
                this.bLs = 0;
            } else {
                this.bLs = 1;
            }
        } else if (point.y == point2.y) {
            this.bLt = Math.abs(point2.x - point.x) / ((float) this.bLv);
            if (point2.x > point.x) {
                this.bLs = 2;
            } else {
                this.bLs = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.bLt = Math.abs(f) / ((float) this.bLv);
            if (f > 0.0f) {
                this.bLs = 5;
            } else {
                this.bLs = 4;
            }
        }
    }

    private int hG(int i) {
        return (int) (((this.k * i) + this.bLm.y) - (this.k * this.bLm.x));
    }

    private long YG() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.bLo.y = (int) (this.bLm.y + (this.bLu * ((float) YG())));
        if (this.bLo.y > this.bLn.y) {
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YB() {
        this.bLo.x = (int) (this.bLm.x + (this.bLt * ((float) YG())));
        if (this.bLo.x > this.bLn.x) {
            this.bLo.x = this.bLn.x;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YC() {
        this.bLo.y = (int) (this.bLm.y - (this.bLu * ((float) YG())));
        if (this.bLo.y < this.bLn.y) {
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YD() {
        this.bLo.x = (int) (this.bLm.x - (this.bLt * ((float) YG())));
        if (this.bLo.x < this.bLn.x) {
            this.bLo.x = this.bLn.x;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YE() {
        boolean z = true;
        this.bLo.x = (int) (this.bLm.x - (this.bLt * ((float) YG())));
        this.bLo.y = hG(this.bLo.x);
        if (this.bLm.y <= this.bLn.y ? this.bLo.y <= this.bLn.y : this.bLo.y >= this.bLn.y) {
            z = false;
        }
        if (this.bLo.x < this.bLn.x || z) {
            this.bLo.x = this.bLn.x;
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }

    private void YF() {
        boolean z = true;
        this.bLo.x = (int) (this.bLm.x + (this.bLt * ((float) YG())));
        this.bLo.y = hG(this.bLo.x);
        if (this.bLm.y <= this.bLn.y ? this.bLo.y <= this.bLn.y : this.bLo.y >= this.bLn.y) {
            z = false;
        }
        if (this.bLo.x > this.bLn.x || z) {
            this.bLo.x = this.bLn.x;
            this.bLo.y = this.bLn.y;
        }
        if (this.bLr != null) {
            this.bLr.a(this.bLo);
        }
    }
}
