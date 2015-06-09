package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e btO;
    private int btP;
    private float btQ;
    private float btR;
    private final long btS;
    private float k;
    private long startTime;
    private Point btJ = new Point();
    private Point btL = new Point();
    private Point btK = new Point();

    public f(long j) {
        this.btS = j;
    }

    public void a(e eVar) {
        this.btO = eVar;
    }

    public void a(Point point, Point point2) {
        this.btJ.x = point.x;
        this.btJ.y = point.y;
        this.btL.x = point.x;
        this.btL.y = point.y;
        this.btK.x = point2.x;
        this.btK.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.btR = Math.abs(point2.y - point.y) / ((float) this.btS);
            if (point2.y > point.y) {
                this.btP = 0;
            } else {
                this.btP = 1;
            }
        } else if (point.y == point2.y) {
            this.btQ = Math.abs(point2.x - point.x) / ((float) this.btS);
            if (point2.x > point.x) {
                this.btP = 2;
            } else {
                this.btP = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.btQ = Math.abs(f) / ((float) this.btS);
            if (f > 0.0f) {
                this.btP = 5;
            } else {
                this.btP = 4;
            }
        }
    }

    private int gM(int i) {
        return (int) (((this.k * i) + this.btJ.y) - (this.k * this.btJ.x));
    }

    private long Wp() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.btL.equals(this.btK)) {
            switch (this.btP) {
                case 0:
                    Wj();
                    break;
                case 1:
                    Wl();
                    break;
                case 2:
                    Wk();
                    break;
                case 3:
                    Wm();
                    break;
                case 4:
                    Wn();
                    break;
                case 5:
                    Wo();
                    break;
            }
            return false;
        }
        if (this.btO != null) {
            this.btO.Wc();
        }
        return true;
    }

    private void Wj() {
        this.btL.y = (int) (this.btJ.y + (this.btR * ((float) Wp())));
        if (this.btL.y > this.btK.y) {
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wk() {
        this.btL.x = (int) (this.btJ.x + (this.btQ * ((float) Wp())));
        if (this.btL.x > this.btK.x) {
            this.btL.x = this.btK.x;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wl() {
        this.btL.y = (int) (this.btJ.y - (this.btR * ((float) Wp())));
        if (this.btL.y < this.btK.y) {
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wm() {
        this.btL.x = (int) (this.btJ.x - (this.btQ * ((float) Wp())));
        if (this.btL.x < this.btK.x) {
            this.btL.x = this.btK.x;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wn() {
        boolean z = true;
        this.btL.x = (int) (this.btJ.x - (this.btQ * ((float) Wp())));
        this.btL.y = gM(this.btL.x);
        if (this.btJ.y <= this.btK.y ? this.btL.y <= this.btK.y : this.btL.y >= this.btK.y) {
            z = false;
        }
        if (this.btL.x < this.btK.x || z) {
            this.btL.x = this.btK.x;
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }

    private void Wo() {
        boolean z = true;
        this.btL.x = (int) (this.btJ.x + (this.btQ * ((float) Wp())));
        this.btL.y = gM(this.btL.x);
        if (this.btJ.y <= this.btK.y ? this.btL.y <= this.btK.y : this.btL.y >= this.btK.y) {
            z = false;
        }
        if (this.btL.x > this.btK.x || z) {
            this.btL.x = this.btK.x;
            this.btL.y = this.btK.y;
        }
        if (this.btO != null) {
            this.btO.a(this.btL);
        }
    }
}
