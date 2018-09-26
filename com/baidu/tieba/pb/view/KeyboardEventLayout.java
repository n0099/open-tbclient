package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class KeyboardEventLayout extends RelativeLayout {
    private a fVw;
    public int maxHeight;

    /* loaded from: classes2.dex */
    public interface a {
        void rx(int i);
    }

    public void setOnKeyStateChangedListener(a aVar) {
        this.fVw = aVar;
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.maxHeight = 0;
        this.fVw = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.maxHeight = 0;
        this.fVw = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = 0;
        this.fVw = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.maxHeight = Math.max(Math.max(i4, i2), this.maxHeight);
        if (i4 != 0 && this.fVw != null) {
            if (i4 > i2) {
                this.fVw.rx(0);
            } else if (i4 < i2 && i2 >= this.maxHeight) {
                this.fVw.rx(1);
            }
        }
    }
}
