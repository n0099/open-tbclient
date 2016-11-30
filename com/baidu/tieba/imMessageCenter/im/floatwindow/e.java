package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int dvK;
    private int dvL;
    private int radius;

    public boolean a(e eVar) {
        return ((this.dvK - eVar.dvK) * (this.dvK - eVar.dvK)) + ((this.dvL - eVar.dvL) * (this.dvL - eVar.dvL)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aI(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        J(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void J(int i, int i2, int i3) {
        this.dvK = i;
        this.dvL = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.dvK == 0 && this.dvL == 0 && this.radius == 0;
    }
}
