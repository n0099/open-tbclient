package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardEventLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f1495a;
    private ae b;

    public void setOnKeyStateChangedListener(ae aeVar) {
        this.b = aeVar;
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.f1495a = 0;
        this.b = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.f1495a = 0;
        this.b = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1495a = 0;
        this.b = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1495a = Math.max(Math.max(i4, i2), this.f1495a);
        if (i4 != 0 && this.b != null) {
            if (i4 > i2) {
                this.b.a(0);
            } else if (i4 < i2 && i2 >= this.f1495a) {
                this.b.a(1);
            }
        }
    }
}
