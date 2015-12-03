package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int caH;
    private int caI;
    private int radius;

    public boolean a(e eVar) {
        return ((this.caH - eVar.caH) * (this.caH - eVar.caH)) + ((this.caI - eVar.caI) * (this.caI - eVar.caI)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void W(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.caH = i;
        this.caI = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.caH == 0 && this.caI == 0 && this.radius == 0;
    }
}
