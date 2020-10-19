package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class TransparentBgLinearLayout extends LinearLayout {
    public TransparentBgLinearLayout(Context context) {
        this(context, null);
    }

    public TransparentBgLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransparentBgLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.argb(168, 0, 0, 0), PorterDuff.Mode.SRC);
        super.onDraw(canvas);
    }
}
