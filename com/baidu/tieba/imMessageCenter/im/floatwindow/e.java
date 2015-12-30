package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int ceI;
    private int ceJ;
    private int radius;

    public boolean a(e eVar) {
        return ((this.ceI - eVar.ceI) * (this.ceI - eVar.ceI)) + ((this.ceJ - eVar.ceJ) * (this.ceJ - eVar.ceJ)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void ab(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        F(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void F(int i, int i2, int i3) {
        this.ceI = i;
        this.ceJ = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.ceI == 0 && this.ceJ == 0 && this.radius == 0;
    }
}
