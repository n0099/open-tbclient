package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int bHl;
    private int bHm;
    private int radius;

    public boolean a(e eVar) {
        return ((this.bHl - eVar.bHl) * (this.bHl - eVar.bHl)) + ((this.bHm - eVar.bHm) * (this.bHm - eVar.bHm)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void O(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        s(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void s(int i, int i2, int i3) {
        this.bHl = i;
        this.bHm = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bHl == 0 && this.bHm == 0 && this.radius == 0;
    }
}
