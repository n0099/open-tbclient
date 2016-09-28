package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int dqd;
    private int dqe;
    private int radius;

    public boolean a(e eVar) {
        return ((this.dqd - eVar.dqd) * (this.dqd - eVar.dqd)) + ((this.dqe - eVar.dqe) * (this.dqe - eVar.dqe)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aJ(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        J(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void J(int i, int i2, int i3) {
        this.dqd = i;
        this.dqe = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.dqd == 0 && this.dqe == 0 && this.radius == 0;
    }
}
