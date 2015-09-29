package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int bKX;
    private int bKY;
    private int radius;

    public boolean a(e eVar) {
        return ((this.bKX - eVar.bKX) * (this.bKX - eVar.bKX)) + ((this.bKY - eVar.bKY) * (this.bKY - eVar.bKY)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void Q(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.bKX = i;
        this.bKY = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bKX == 0 && this.bKY == 0 && this.radius == 0;
    }
}
