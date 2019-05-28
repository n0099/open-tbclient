package com.baidu.tieba.im.util;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes5.dex */
public class a implements InputFilter {
    private int gKj;

    public a(int i) {
        this.gKj = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.gKj - (spanned.length() - i5);
        String obj = spanned.toString();
        int qW = f.qW(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int d = qW - f.d(obj.charAt(i6));
                i6++;
                qW = d;
            }
        } else {
            qW += f.qW(charSequence.toString());
        }
        if (qW > this.gKj || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
