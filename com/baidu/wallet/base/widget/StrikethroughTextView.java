package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class StrikethroughTextView extends TextView {
    public StrikethroughTextView(Context context) {
        super(context);
    }

    public void setStrikeText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        SpannableString spannableString = new SpannableString(str + str2);
        if (!TextUtils.isEmpty(str2)) {
            spannableString.setSpan(new StrikethroughSpan(), str.length(), str.length() + str2.length(), 17);
        }
        setText(spannableString);
    }

    public StrikethroughTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StrikethroughTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
