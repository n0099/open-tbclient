package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
/* loaded from: classes.dex */
public class d implements b {
    private c.a dau;
    private int dav;
    private float daw;
    private float dax;
    private final long daz;
    private float k;
    private long startTime;
    private Point dao = new Point();
    private Point daq = new Point();
    private Point dap = new Point();

    public d(long j) {
        this.daz = j;
    }

    public void a(c.a aVar) {
        this.dau = aVar;
    }

    public void a(Point point, Point point2) {
        this.dao.x = point.x;
        this.dao.y = point.y;
        this.daq.x = point.x;
        this.daq.y = point.y;
        this.dap.x = point2.x;
        this.dap.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.dax = Math.abs(point2.y - point.y) / ((float) this.daz);
            if (point2.y > point.y) {
                this.dav = 0;
            } else {
                this.dav = 1;
            }
        } else if (point.y == point2.y) {
            this.daw = Math.abs(point2.x - point.x) / ((float) this.daz);
            if (point2.x > point.x) {
                this.dav = 2;
            } else {
                this.dav = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.daw = Math.abs(f) / ((float) this.daz);
            if (f > 0.0f) {
                this.dav = 5;
            } else {
                this.dav = 4;
            }
        }
    }

    private int lq(int i) {
        return (int) (((this.k * i) + this.dao.y) - (this.k * this.dao.x));
    }

    private long asl() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.daq.equals(this.dap)) {
            switch (this.dav) {
                case 0:
                    asf();
                    break;
                case 1:
                    ash();
                    break;
                case 2:
                    asg();
                    break;
                case 3:
                    asi();
                    break;
                case 4:
                    asj();
                    break;
                case 5:
                    ask();
                    break;
            }
            return false;
        }
        if (this.dau != null) {
            this.dau.arY();
        }
        return true;
    }

    private void asf() {
        this.daq.y = (int) (this.dao.y + (this.dax * ((float) asl())));
        if (this.daq.y > this.dap.y) {
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asg() {
        this.daq.x = (int) (this.dao.x + (this.daw * ((float) asl())));
        if (this.daq.x > this.dap.x) {
            this.daq.x = this.dap.x;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void ash() {
        this.daq.y = (int) (this.dao.y - (this.dax * ((float) asl())));
        if (this.daq.y < this.dap.y) {
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asi() {
        this.daq.x = (int) (this.dao.x - (this.daw * ((float) asl())));
        if (this.daq.x < this.dap.x) {
            this.daq.x = this.dap.x;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asj() {
        boolean z = true;
        this.daq.x = (int) (this.dao.x - (this.daw * ((float) asl())));
        this.daq.y = lq(this.daq.x);
        if (this.dao.y <= this.dap.y ? this.daq.y <= this.dap.y : this.daq.y >= this.dap.y) {
            z = false;
        }
        if (this.daq.x < this.dap.x || z) {
            this.daq.x = this.dap.x;
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void ask() {
        boolean z = true;
        this.daq.x = (int) (this.dao.x + (this.daw * ((float) asl())));
        this.daq.y = lq(this.daq.x);
        if (this.dao.y <= this.dap.y ? this.daq.y <= this.dap.y : this.daq.y >= this.dap.y) {
            z = false;
        }
        if (this.daq.x > this.dap.x || z) {
            this.daq.x = this.dap.x;
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }
}
