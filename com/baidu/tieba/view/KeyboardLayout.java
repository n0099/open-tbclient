package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1833a;
    private boolean b;
    private int c;
    private ao d;

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1833a = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1833a = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.f1833a = false;
    }

    public void setOnkbdStateListener(ao aoVar) {
        this.d = aoVar;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f1833a) {
            this.f1833a = true;
            this.c = i4;
            if (this.d != null) {
                this.d.a(-1);
            }
        } else {
            this.c = this.c < i4 ? i4 : this.c;
        }
        if (this.f1833a && this.c > i4) {
            this.b = true;
            if (this.d != null) {
                this.d.a(-3);
            }
        }
        if (this.f1833a && this.b && this.c == i4) {
            this.b = false;
            if (this.d != null) {
                this.d.a(-2);
            }
        }
    }
}
