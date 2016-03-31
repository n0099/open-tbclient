package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int ctM;
    private int ctN;
    private int radius;

    public boolean a(e eVar) {
        return ((this.ctM - eVar.ctM) * (this.ctM - eVar.ctM)) + ((this.ctN - eVar.ctN) * (this.ctN - eVar.ctN)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aA(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        E(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void E(int i, int i2, int i3) {
        this.ctM = i;
        this.ctN = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.ctM == 0 && this.ctN == 0 && this.radius == 0;
    }
}
