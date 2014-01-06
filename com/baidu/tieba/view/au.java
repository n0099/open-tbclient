package com.baidu.tieba.view;

import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    public int a;
    private av b;

    public void setOnKeyStateChangedListener(av avVar) {
        this.b = avVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = Math.max(Math.max(i4, i2), this.a);
        if (i4 != 0 && this.b != null) {
            if (i4 > i2) {
                this.b.a(0);
            } else if (i4 < i2 && i2 >= this.a) {
                this.b.a(1);
            }
        }
    }
}
