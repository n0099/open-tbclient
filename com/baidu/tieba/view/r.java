package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class r extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f2695a;
    private int b;

    public r(Context context) {
        super(context);
        this.f2695a = 0;
        this.b = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b == 0) {
            setMeasuredDimension(i & 1073741823, this.f2695a);
        } else if (this.f2695a == 0) {
            setMeasuredDimension(this.b, 1073741823 & i2);
        }
    }

    public void setHeightPx(int i) {
        this.f2695a = i;
    }

    public void setWidthPx(int i) {
        this.b = i;
    }

    public void setHeightDip(int i) {
        this.f2695a = com.baidu.adp.lib.h.g.a(getContext(), i);
    }

    public void setWidthDip(int i) {
        this.b = com.baidu.adp.lib.h.g.a(getContext(), i);
    }
}
