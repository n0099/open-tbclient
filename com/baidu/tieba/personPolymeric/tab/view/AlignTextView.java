package com.baidu.tieba.personPolymeric.tab.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.b.b.e.p.k;
/* loaded from: classes5.dex */
public class AlignTextView extends TextView {
    public AlignTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (!(text instanceof String)) {
            super.onDraw(canvas);
            return;
        }
        String str = (String) text;
        Layout layout = getLayout();
        if (!k.isEmpty(str) && layout != null && layout.getLineCount() == 1 && str.length() > 1) {
            int lineBaseline = layout.getLineBaseline(0) + getPaddingTop();
            float measureText = getPaint().measureText(str);
            float paddingLeft = getPaddingLeft();
            float measuredWidth = (((getMeasuredWidth() - measureText) - getPaddingLeft()) - getPaddingRight()) / (str.length() - 1);
            for (int i = 0; i < str.length(); i++) {
                String valueOf = String.valueOf(str.charAt(i));
                float measureText2 = getPaint().measureText(valueOf);
                canvas.drawText(valueOf, paddingLeft, lineBaseline, getPaint());
                paddingLeft += measureText2 + measuredWidth;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        getPaint().setColor(i);
    }

    public AlignTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlignTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getPaint().setColor(colorStateList.getDefaultColor());
    }
}
