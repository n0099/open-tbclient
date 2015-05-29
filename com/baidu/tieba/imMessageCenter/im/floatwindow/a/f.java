package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e btN;
    private int btO;
    private float btP;
    private float btQ;
    private final long btR;
    private float k;
    private long startTime;
    private Point btI = new Point();
    private Point btK = new Point();
    private Point btJ = new Point();

    public f(long j) {
        this.btR = j;
    }

    public void a(e eVar) {
        this.btN = eVar;
    }

    public void a(Point point, Point point2) {
        this.btI.x = point.x;
        this.btI.y = point.y;
        this.btK.x = point.x;
        this.btK.y = point.y;
        this.btJ.x = point2.x;
        this.btJ.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.btQ = Math.abs(point2.y - point.y) / ((float) this.btR);
            if (point2.y > point.y) {
                this.btO = 0;
            } else {
                this.btO = 1;
            }
        } else if (point.y == point2.y) {
            this.btP = Math.abs(point2.x - point.x) / ((float) this.btR);
            if (point2.x > point.x) {
                this.btO = 2;
            } else {
                this.btO = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.btP = Math.abs(f) / ((float) this.btR);
            if (f > 0.0f) {
                this.btO = 5;
            } else {
                this.btO = 4;
            }
        }
    }

    private int gM(int i) {
        return (int) (((this.k * i) + this.btI.y) - (this.k * this.btI.x));
    }

    private long Wo() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c
    public boolean execute() {
        if (!this.btK.equals(this.btJ)) {
            switch (this.btO) {
                case 0:
                    Wi();
                    break;
                case 1:
                    Wk();
                    break;
                case 2:
                    Wj();
                    break;
                case 3:
                    Wl();
                    break;
                case 4:
                    Wm();
                    break;
                case 5:
                    Wn();
                    break;
            }
            return false;
        }
        if (this.btN != null) {
            this.btN.Wb();
        }
        return true;
    }

    private void Wi() {
        this.btK.y = (int) (this.btI.y + (this.btQ * ((float) Wo())));
        if (this.btK.y > this.btJ.y) {
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wj() {
        this.btK.x = (int) (this.btI.x + (this.btP * ((float) Wo())));
        if (this.btK.x > this.btJ.x) {
            this.btK.x = this.btJ.x;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wk() {
        this.btK.y = (int) (this.btI.y - (this.btQ * ((float) Wo())));
        if (this.btK.y < this.btJ.y) {
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wl() {
        this.btK.x = (int) (this.btI.x - (this.btP * ((float) Wo())));
        if (this.btK.x < this.btJ.x) {
            this.btK.x = this.btJ.x;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wm() {
        boolean z = true;
        this.btK.x = (int) (this.btI.x - (this.btP * ((float) Wo())));
        this.btK.y = gM(this.btK.x);
        if (this.btI.y <= this.btJ.y ? this.btK.y <= this.btJ.y : this.btK.y >= this.btJ.y) {
            z = false;
        }
        if (this.btK.x < this.btJ.x || z) {
            this.btK.x = this.btJ.x;
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }

    private void Wn() {
        boolean z = true;
        this.btK.x = (int) (this.btI.x + (this.btP * ((float) Wo())));
        this.btK.y = gM(this.btK.x);
        if (this.btI.y <= this.btJ.y ? this.btK.y <= this.btJ.y : this.btK.y >= this.btJ.y) {
            z = false;
        }
        if (this.btK.x > this.btJ.x || z) {
            this.btK.x = this.btJ.x;
            this.btK.y = this.btJ.y;
        }
        if (this.btN != null) {
            this.btN.a(this.btK);
        }
    }
}
