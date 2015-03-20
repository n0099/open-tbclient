package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int bqt;
    private int bqu;
    private int radius;

    public boolean a(j jVar) {
        return ((this.bqt - jVar.bqt) * (this.bqt - jVar.bqt)) + ((this.bqu - jVar.bqu) * (this.bqu - jVar.bqu)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void G(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void u(int i, int i2, int i3) {
        this.bqt = i;
        this.bqu = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bqt == 0 && this.bqu == 0 && this.radius == 0;
    }
}
