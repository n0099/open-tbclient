package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int bHS;
    private int bHT;
    private int radius;

    public boolean a(e eVar) {
        return ((this.bHS - eVar.bHS) * (this.bHS - eVar.bHS)) + ((this.bHT - eVar.bHT) * (this.bHT - eVar.bHT)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void O(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        s(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void s(int i, int i2, int i3) {
        this.bHS = i;
        this.bHT = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bHS == 0 && this.bHT == 0 && this.radius == 0;
    }
}
