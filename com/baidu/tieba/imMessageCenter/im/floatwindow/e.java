package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int cjh;
    private int cji;
    private int radius;

    public boolean a(e eVar) {
        return ((this.cjh - eVar.cjh) * (this.cjh - eVar.cjh)) + ((this.cji - eVar.cji) * (this.cji - eVar.cji)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void ap(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        E(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void E(int i, int i2, int i3) {
        this.cjh = i;
        this.cji = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.cjh == 0 && this.cji == 0 && this.radius == 0;
    }
}
