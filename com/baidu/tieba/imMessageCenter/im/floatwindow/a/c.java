package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point dvZ;
    private Point dwa;
    private Point dwb;
    private final int dwc;
    private final int dwd;
    private a dwe;
    private int dwf;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void azU();
    }

    private int mp(int i) {
        return (int) (((this.k * i) + this.dvZ.y) - (this.k * this.dvZ.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.dwb.equals(this.dwa)) {
            switch (this.dwf) {
                case 0:
                    aAb();
                    break;
                case 1:
                    aAd();
                    break;
                case 2:
                    aAc();
                    break;
                case 3:
                    aAe();
                    break;
                case 4:
                    aAf();
                    break;
                case 5:
                    aAg();
                    break;
            }
            return false;
        }
        if (this.dwe != null) {
            this.dwe.azU();
        }
        return true;
    }

    private void aAb() {
        this.dwb.y += this.dwd;
        if (this.dwb.y > this.dwa.y) {
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAc() {
        this.dwb.x += this.dwc;
        if (this.dwb.x > this.dwa.x) {
            this.dwb.x = this.dwa.x;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAd() {
        this.dwb.y -= this.dwd;
        if (this.dwb.y < this.dwa.y) {
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAe() {
        this.dwb.x -= this.dwc;
        if (this.dwb.x < this.dwa.x) {
            this.dwb.x = this.dwa.x;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAf() {
        this.dwb.x -= this.dwc;
        this.dwb.y = mp(this.dwb.x);
        if (this.dwb.x < this.dwa.x && this.dwb.y < this.dwa.y) {
            this.dwb.x = this.dwa.x;
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }

    private void aAg() {
        this.dwb.x += this.dwc;
        this.dwb.y = mp(this.dwb.x);
        if (this.dwb.x > this.dwa.x && this.dwb.y > this.dwa.y) {
            this.dwb.x = this.dwa.x;
            this.dwb.y = this.dwa.y;
        }
        if (this.dwe != null) {
            this.dwe.a(this.dwb);
        }
    }
}
