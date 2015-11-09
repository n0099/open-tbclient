package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int bLD;
    private int bLE;
    private int radius;

    public boolean a(e eVar) {
        return ((this.bLD - eVar.bLD) * (this.bLD - eVar.bLD)) + ((this.bLE - eVar.bLE) * (this.bLE - eVar.bLE)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void P(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.bLD = i;
        this.bLE = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bLD == 0 && this.bLE == 0 && this.radius == 0;
    }
}
