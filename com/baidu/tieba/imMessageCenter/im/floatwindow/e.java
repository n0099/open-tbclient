package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int doF;
    private int doG;
    private int radius;

    public boolean a(e eVar) {
        return ((this.doF - eVar.doF) * (this.doF - eVar.doF)) + ((this.doG - eVar.doG) * (this.doG - eVar.doG)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aK(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        H(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void H(int i, int i2, int i3) {
        this.doF = i;
        this.doG = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.doF == 0 && this.doG == 0 && this.radius == 0;
    }
}
