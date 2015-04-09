package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int bqJ;
    private int bqK;
    private int radius;

    public boolean a(j jVar) {
        return ((this.bqJ - jVar.bqJ) * (this.bqJ - jVar.bqJ)) + ((this.bqK - jVar.bqK) * (this.bqK - jVar.bqK)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void G(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void u(int i, int i2, int i3) {
        this.bqJ = i;
        this.bqK = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.bqJ == 0 && this.bqK == 0 && this.radius == 0;
    }
}
