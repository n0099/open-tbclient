package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes22.dex */
public class a implements InputFilter {
    private int mMax;

    public a(int i) {
        this.mMax = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.mMax - (spanned.length() - i5);
        String obj = spanned.toString();
        int textLength = f.getTextLength(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int charLength = textLength - f.getCharLength(obj.charAt(i6));
                i6++;
                textLength = charLength;
            }
        } else {
            textLength += f.getTextLength(charSequence.toString());
        }
        if (textLength > this.mMax || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
