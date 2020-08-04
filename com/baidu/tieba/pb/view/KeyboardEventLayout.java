package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes16.dex */
public class KeyboardEventLayout extends RelativeLayout {
    private a kJk;
    public int maxHeight;

    /* loaded from: classes16.dex */
    public interface a {
        void Cn(int i);
    }

    public void setOnKeyStateChangedListener(a aVar) {
        this.kJk = aVar;
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.maxHeight = 0;
        this.kJk = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.maxHeight = 0;
        this.kJk = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = 0;
        this.kJk = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.maxHeight = Math.max(Math.max(i4, i2), this.maxHeight);
        if (i4 != 0 && this.kJk != null) {
            if (i4 > i2) {
                this.kJk.Cn(0);
            } else if (i4 < i2 && i2 >= this.maxHeight) {
                this.kJk.Cn(1);
            }
        }
    }
}
