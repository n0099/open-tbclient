package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class AccountTextView extends TextView {
    public AccountTextView(Context context) {
        super(context);
    }

    public AccountTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AccountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getText() != null ? Math.min(((int) getPaint().measureText((String) getText())) + getCompoundPaddingLeft() + getCompoundPaddingRight(), size) : size, 1073741824), i2);
    }
}
