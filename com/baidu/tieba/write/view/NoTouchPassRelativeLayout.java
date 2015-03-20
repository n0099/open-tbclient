package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class NoTouchPassRelativeLayout extends RelativeLayout {
    public NoTouchPassRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NoTouchPassRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoTouchPassRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
