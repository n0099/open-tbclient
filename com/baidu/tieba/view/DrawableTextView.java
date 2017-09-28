package com.baidu.tieba.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
/* loaded from: classes.dex */
public class DrawableTextView extends TextView {
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
