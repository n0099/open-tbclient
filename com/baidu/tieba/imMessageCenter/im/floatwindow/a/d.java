package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private float dqA;
    private final long dqB;
    private c.a dqx;
    private int dqy;
    private float dqz;
    private float k;
    private long startTime;
    private Point dqs = new Point();
    private Point dqu = new Point();
    private Point dqt = new Point();

    public d(long j) {
        this.dqB = j;
    }

    public void a(c.a aVar) {
        this.dqx = aVar;
    }

    public void a(Point point, Point point2) {
        this.dqs.x = point.x;
        this.dqs.y = point.y;
        this.dqu.x = point.x;
        this.dqu.y = point.y;
        this.dqt.x = point2.x;
        this.dqt.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.dqA = Math.abs(point2.y - point.y) / ((float) this.dqB);
            if (point2.y > point.y) {
                this.dqy = 0;
            } else {
                this.dqy = 1;
            }
        } else if (point.y == point2.y) {
            this.dqz = Math.abs(point2.x - point.x) / ((float) this.dqB);
            if (point2.x > point.x) {
                this.dqy = 2;
            } else {
                this.dqy = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.dqz = Math.abs(f) / ((float) this.dqB);
            if (f > 0.0f) {
                this.dqy = 5;
            } else {
                this.dqy = 4;
            }
        }
    }

    private int mh(int i) {
        return (int) (((this.k * i) + this.dqs.y) - (this.k * this.dqs.x));
    }

    private long Tg() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.dqu.equals(this.dqt)) {
            switch (this.dqy) {
                case 0:
                    aye();
                    break;
                case 1:
                    ayg();
                    break;
                case 2:
                    ayf();
                    break;
                case 3:
                    ayh();
                    break;
                case 4:
                    ayi();
                    break;
                case 5:
                    ayj();
                    break;
            }
            return false;
        }
        if (this.dqx != null) {
            this.dqx.axX();
        }
        return true;
    }

    private void aye() {
        this.dqu.y = (int) (this.dqs.y + (this.dqA * ((float) Tg())));
        if (this.dqu.y > this.dqt.y) {
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayf() {
        this.dqu.x = (int) (this.dqs.x + (this.dqz * ((float) Tg())));
        if (this.dqu.x > this.dqt.x) {
            this.dqu.x = this.dqt.x;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayg() {
        this.dqu.y = (int) (this.dqs.y - (this.dqA * ((float) Tg())));
        if (this.dqu.y < this.dqt.y) {
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayh() {
        this.dqu.x = (int) (this.dqs.x - (this.dqz * ((float) Tg())));
        if (this.dqu.x < this.dqt.x) {
            this.dqu.x = this.dqt.x;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayi() {
        boolean z = true;
        this.dqu.x = (int) (this.dqs.x - (this.dqz * ((float) Tg())));
        this.dqu.y = mh(this.dqu.x);
        if (this.dqs.y <= this.dqt.y ? this.dqu.y <= this.dqt.y : this.dqu.y >= this.dqt.y) {
            z = false;
        }
        if (this.dqu.x < this.dqt.x || z) {
            this.dqu.x = this.dqt.x;
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }

    private void ayj() {
        boolean z = true;
        this.dqu.x = (int) (this.dqs.x + (this.dqz * ((float) Tg())));
        this.dqu.y = mh(this.dqu.x);
        if (this.dqs.y <= this.dqt.y ? this.dqu.y <= this.dqt.y : this.dqu.y >= this.dqt.y) {
            z = false;
        }
        if (this.dqu.x > this.dqt.x || z) {
            this.dqu.x = this.dqt.x;
            this.dqu.y = this.dqt.y;
        }
        if (this.dqx != null) {
            this.dqx.a(this.dqu);
        }
    }
}
