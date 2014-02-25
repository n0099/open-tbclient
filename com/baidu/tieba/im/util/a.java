package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
public class a implements InputFilter {
    private int a;

    public a(int i) {
        this.a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.a - (spanned.length() - i5);
        String spanned2 = spanned.toString();
        int a = p.a(spanned2);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && spanned2.length() < i6) {
                int a2 = a - p.a(spanned2.charAt(i6));
                i6++;
                a = a2;
            }
        } else {
            a += p.a(charSequence.toString());
        }
        if (a > this.a || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
