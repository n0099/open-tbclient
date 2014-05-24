package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class AccountTextView extends TextView {
    private String a;

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
        int i3;
        String str = (String) getText();
        int size = View.MeasureSpec.getSize(i);
        int measureText = (int) (getPaint().measureText(str) + getCompoundPaddingLeft() + getCompoundPaddingRight());
        if (TextUtils.isEmpty(str) || str.equals(this.a) || measureText <= size) {
            i3 = measureText;
        } else {
            String str2 = str;
            i3 = measureText;
            while (i3 > size && str2.length() > 1) {
                str2 = str2.substring(0, str2.length() - 1);
                i3 = (int) (getPaint().measureText(String.valueOf(str2) + "...") + getCompoundPaddingLeft() + getCompoundPaddingRight());
            }
            String str3 = String.valueOf(str2) + "...";
            this.a = str3;
            setText(str3);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
    }
}
