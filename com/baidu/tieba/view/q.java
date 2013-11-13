package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class q extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f2594a;
    private int b;

    public q(Context context) {
        super(context);
        this.f2594a = 0;
        this.b = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b == 0) {
            setMeasuredDimension(i & 1073741823, this.f2594a);
        } else if (this.f2594a == 0) {
            setMeasuredDimension(this.b, 1073741823 & i2);
        }
    }

    public void setHeightPx(int i) {
        this.f2594a = i;
    }

    public void setWidthPx(int i) {
        this.b = i;
    }

    public void setHeightDip(int i) {
        this.f2594a = UtilHelper.a(getContext(), i);
    }

    public void setWidthDip(int i) {
        this.b = UtilHelper.a(getContext(), i);
    }
}
