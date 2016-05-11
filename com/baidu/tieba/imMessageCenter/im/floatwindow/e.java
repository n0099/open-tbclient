package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int cuK;
    private int cuL;
    private int radius;

    public boolean a(e eVar) {
        return ((this.cuK - eVar.cuK) * (this.cuK - eVar.cuK)) + ((this.cuL - eVar.cuL) * (this.cuL - eVar.cuL)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aE(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        D(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void D(int i, int i2, int i3) {
        this.cuK = i;
        this.cuL = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.cuK == 0 && this.cuL == 0 && this.radius == 0;
    }
}
