package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes3.dex */
public class a implements InputFilter {
    private int eNK;

    public a(int i) {
        this.eNK = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.eNK - (spanned.length() - i5);
        String obj = spanned.toString();
        int hs = f.hs(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int e = hs - f.e(obj.charAt(i6));
                i6++;
                hs = e;
            }
        } else {
            hs += f.hs(charSequence.toString());
        }
        if (hs > this.eNK || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
