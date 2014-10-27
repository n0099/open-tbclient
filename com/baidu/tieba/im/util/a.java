package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
public class a implements InputFilter {
    private int biE;

    public a(int i) {
        this.biE = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.biE - (spanned.length() - i5);
        String spanned2 = spanned.toString();
        int fy = j.fy(spanned2);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && spanned2.length() < i6) {
                int b = fy - j.b(spanned2.charAt(i6));
                i6++;
                fy = b;
            }
        } else {
            fy += j.fy(charSequence.toString());
        }
        if (fy > this.biE || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
