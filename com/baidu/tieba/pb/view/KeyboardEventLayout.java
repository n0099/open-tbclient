package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class KeyboardEventLayout extends RelativeLayout {
    private a iZV;
    public int maxHeight;

    /* loaded from: classes7.dex */
    public interface a {
        void zj(int i);
    }

    public void setOnKeyStateChangedListener(a aVar) {
        this.iZV = aVar;
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.maxHeight = 0;
        this.iZV = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.maxHeight = 0;
        this.iZV = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = 0;
        this.iZV = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.maxHeight = Math.max(Math.max(i4, i2), this.maxHeight);
        if (i4 != 0 && this.iZV != null) {
            if (i4 > i2) {
                this.iZV.zj(0);
            } else if (i4 < i2 && i2 >= this.maxHeight) {
                this.iZV.zj(1);
            }
        }
    }
}
