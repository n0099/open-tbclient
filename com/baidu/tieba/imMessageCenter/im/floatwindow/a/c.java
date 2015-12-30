package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point ceX;
    private Point ceY;
    private Point ceZ;
    private final int cfa;
    private final int cfb;
    private a cfc;
    private int cfd;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void acZ();
    }

    private int jg(int i) {
        return (int) (((this.k * i) + this.ceX.y) - (this.k * this.ceX.x));
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.b
    public boolean execute() {
        if (!this.ceZ.equals(this.ceY)) {
            switch (this.cfd) {
                case 0:
                    adg();
                    break;
                case 1:
                    adi();
                    break;
                case 2:
                    adh();
                    break;
                case 3:
                    adj();
                    break;
                case 4:
                    adk();
                    break;
                case 5:
                    adl();
                    break;
            }
            return false;
        }
        if (this.cfc != null) {
            this.cfc.acZ();
        }
        return true;
    }

    private void adg() {
        this.ceZ.y += this.cfb;
        if (this.ceZ.y > this.ceY.y) {
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adh() {
        this.ceZ.x += this.cfa;
        if (this.ceZ.x > this.ceY.x) {
            this.ceZ.x = this.ceY.x;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adi() {
        this.ceZ.y -= this.cfb;
        if (this.ceZ.y < this.ceY.y) {
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adj() {
        this.ceZ.x -= this.cfa;
        if (this.ceZ.x < this.ceY.x) {
            this.ceZ.x = this.ceY.x;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adk() {
        this.ceZ.x -= this.cfa;
        this.ceZ.y = jg(this.ceZ.x);
        if (this.ceZ.x < this.ceY.x && this.ceZ.y < this.ceY.y) {
            this.ceZ.x = this.ceY.x;
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }

    private void adl() {
        this.ceZ.x += this.cfa;
        this.ceZ.y = jg(this.ceZ.x);
        if (this.ceZ.x > this.ceY.x && this.ceZ.y > this.ceY.y) {
            this.ceZ.x = this.ceY.x;
            this.ceZ.y = this.ceY.y;
        }
        if (this.cfc != null) {
            this.cfc.a(this.ceZ);
        }
    }
}
