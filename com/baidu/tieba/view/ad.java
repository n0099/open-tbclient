package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public final class ad extends View {
    private int a;
    private int b;

    public ad(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        if (this.b == 0) {
            setMeasuredDimension(i & 1073741823, this.a);
        } else if (this.a == 0) {
            setMeasuredDimension(this.b, 1073741823 & i2);
        }
    }

    public final void setHeightPx(int i) {
        this.a = i;
    }

    public final void setWidthPx(int i) {
        this.b = i;
    }

    public final void setHeightDip(int i) {
        this.a = BdUtilHelper.a(getContext(), i);
    }

    public final void setWidthDip(int i) {
        this.b = BdUtilHelper.a(getContext(), i);
    }
}
