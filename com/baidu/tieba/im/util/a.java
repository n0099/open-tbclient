package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes3.dex */
public class a implements InputFilter {
    private int eZx;

    public a(int i) {
        this.eZx = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.eZx - (spanned.length() - i5);
        String obj = spanned.toString();
        int iL = f.iL(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int d = iL - f.d(obj.charAt(i6));
                i6++;
                iL = d;
            }
        } else {
            iL += f.iL(charSequence.toString());
        }
        if (iL > this.eZx || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
