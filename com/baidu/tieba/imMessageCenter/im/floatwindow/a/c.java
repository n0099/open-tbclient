package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class c implements b {
    private Point dao;
    private Point dap;
    private Point daq;
    private final int dar;
    private final int das;
    private a dau;
    private int dav;
    private float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(Point point);

        void arY();
    }

    private int lq(int i) {
        return (int) (((this.k * i) + this.dao.y) - (this.k * this.dao.x));
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
        this.daq.y += this.das;
        if (this.daq.y > this.dap.y) {
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asg() {
        this.daq.x += this.dar;
        if (this.daq.x > this.dap.x) {
            this.daq.x = this.dap.x;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void ash() {
        this.daq.y -= this.das;
        if (this.daq.y < this.dap.y) {
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asi() {
        this.daq.x -= this.dar;
        if (this.daq.x < this.dap.x) {
            this.daq.x = this.dap.x;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void asj() {
        this.daq.x -= this.dar;
        this.daq.y = lq(this.daq.x);
        if (this.daq.x < this.dap.x && this.daq.y < this.dap.y) {
            this.daq.x = this.dap.x;
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }

    private void ask() {
        this.daq.x += this.dar;
        this.daq.y = lq(this.daq.x);
        if (this.daq.x > this.dap.x && this.daq.y > this.dap.y) {
            this.daq.x = this.dap.x;
            this.daq.y = this.dap.y;
        }
        if (this.dau != null) {
            this.dau.a(this.daq);
        }
    }
}
