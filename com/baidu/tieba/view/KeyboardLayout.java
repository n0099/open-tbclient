package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    private boolean a;
    private boolean b;
    private int c;
    private aa d;

    public KeyboardLayout(Context context) {
        super(context);
        this.a = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a) {
            this.c = this.c < i4 ? i4 : this.c;
        } else {
            this.a = true;
            this.c = i4;
            if (this.d != null) {
                this.d.a(-1);
            }
        }
        if (this.a && this.c > i4) {
            this.b = true;
            if (this.d != null) {
                this.d.a(-3);
            }
        }
        if (this.a && this.b && this.c == i4) {
            this.b = false;
            if (this.d != null) {
                this.d.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(aa aaVar) {
        this.d = aaVar;
    }
}
