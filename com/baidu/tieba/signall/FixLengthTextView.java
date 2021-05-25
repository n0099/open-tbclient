package com.baidu.tieba.signall;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R$styleable;
/* loaded from: classes5.dex */
public class FixLengthTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public String f20545e;

    public FixLengthTextView(Context context) {
        this(context, null, 0);
    }

    public String getmMeasureText() {
        return this.f20545e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!TextUtils.isEmpty(this.f20545e)) {
            int desiredWidth = ((int) Layout.getDesiredWidth(this.f20545e, getPaint())) + getPaddingLeft() + getPaddingRight();
            int size = View.MeasureSpec.getSize(i2);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                desiredWidth = Math.max(desiredWidth, size);
            }
            i2 = View.MeasureSpec.makeMeasureSpec(desiredWidth, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setmMeasureText(String str) {
        this.f20545e = str;
    }

    public FixLengthTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixLengthTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.fixtextview);
        this.f20545e = obtainStyledAttributes.getString(obtainStyledAttributes.getIndex(R$styleable.fixtextview_measuretext));
        obtainStyledAttributes.recycle();
    }
}
