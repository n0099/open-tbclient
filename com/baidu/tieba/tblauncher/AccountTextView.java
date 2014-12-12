package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class AccountTextView extends TextView {
    private String text;

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
        String a = com.baidu.adp.lib.util.k.a(getText(), "");
        int size = View.MeasureSpec.getSize(i);
        int measureText = (int) (getPaint().measureText(a) + getCompoundPaddingLeft() + getCompoundPaddingRight());
        if (!TextUtils.isEmpty(a) && !a.equals(this.text) && measureText > size) {
            while (measureText > size && a.length() > 1) {
                a = a.substring(0, a.length() - 1);
                measureText = (int) (getPaint().measureText(String.valueOf(a) + "...") + getCompoundPaddingLeft() + getCompoundPaddingRight());
            }
            String str = String.valueOf(a) + "...";
            this.text = str;
            setText(str);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measureText, 1073741824), i2);
    }
}
