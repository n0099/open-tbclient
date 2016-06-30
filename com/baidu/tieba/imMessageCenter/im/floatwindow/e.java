package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class e {
    private int cZZ;
    private int daa;
    private int radius;

    public boolean a(e eVar) {
        return ((this.cZZ - eVar.cZZ) * (this.cZZ - eVar.cZZ)) + ((this.daa - eVar.daa) * (this.daa - eVar.daa)) < (this.radius + eVar.radius) * (this.radius + eVar.radius);
    }

    public void aM(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        F(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void F(int i, int i2, int i3) {
        this.cZZ = i;
        this.daa = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.cZZ == 0 && this.daa == 0 && this.radius == 0;
    }
}
