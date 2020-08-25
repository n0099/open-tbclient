package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class DrawableTextView extends TextView {
    public DrawableTextView(Context context) {
        super(context);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (drawable = compoundDrawables[0]) != null && getText().toString() != null) {
            canvas.translate((getWidth() - ((drawable.getIntrinsicWidth() + getPaint().measureText(getText().toString())) + getCompoundDrawablePadding())) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
