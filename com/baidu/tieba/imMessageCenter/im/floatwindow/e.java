package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int bLi;
    private int bLj;
    private int radius;

    public boolean a(e eVar) {
        return ((this.bLi - eVar.bLi) * (this.bLi - eVar.bLi)) + ((this.bLj - eVar.bLj) * (this.bLj - eVar.bLj)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void Q(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.bLi = i;
        this.bLj = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bLi == 0 && this.bLj == 0 && this.radius == 0;
    }
}
