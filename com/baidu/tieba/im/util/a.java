package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes3.dex */
public class a implements InputFilter {
    private int euL;

    public a(int i) {
        this.euL = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.euL - (spanned.length() - i5);
        String obj = spanned.toString();
        int hG = f.hG(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int d = hG - f.d(obj.charAt(i6));
                i6++;
                hG = d;
            }
        } else {
            hG += f.hG(charSequence.toString());
        }
        if (hG > this.euL || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
