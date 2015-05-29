package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int btt;
    private int btu;
    private int radius;

    public boolean a(j jVar) {
        return ((this.btt - jVar.btt) * (this.btt - jVar.btt)) + ((this.btu - jVar.btu) * (this.btu - jVar.btu)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void J(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        u(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void u(int i, int i2, int i3) {
        this.btt = i;
        this.btu = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.btt == 0 && this.btu == 0 && this.radius == 0;
    }
}
