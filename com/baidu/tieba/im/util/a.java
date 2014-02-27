package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
public final class a implements InputFilter {
    private int a = 20;

    public a(int i) {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int a;
        int i5 = i4 - i3;
        int length = this.a - (spanned.length() - i5);
        String spanned2 = spanned.toString();
        int a2 = o.a(spanned2);
        if (i5 > 0) {
            int i6 = i3;
            while (true) {
                if (i6 < i5 + i3) {
                    if (spanned2.length() >= i6) {
                        a = a2;
                        break;
                    }
                    a2 -= o.a(spanned2.charAt(i6)) ? 1 : 2;
                    i6++;
                } else {
                    a = a2;
                    break;
                }
            }
        } else {
            a = o.a(charSequence.toString()) + a2;
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
