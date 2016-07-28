package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int dcX;
    private int dcY;
    private int radius;

    public boolean a(e eVar) {
        return ((this.dcX - eVar.dcX) * (this.dcX - eVar.dcX)) + ((this.dcY - eVar.dcY) * (this.dcY - eVar.dcY)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aK(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        G(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void G(int i, int i2, int i3) {
        this.dcX = i;
        this.dcY = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.dcX == 0 && this.dcY == 0 && this.radius == 0;
    }
}
