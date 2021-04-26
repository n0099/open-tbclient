package com.baidu.tieba.wallet.pay;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
/* loaded from: classes5.dex */
public class BuyTBeanStringUlti {
    public static String formatTBeanNum(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        String valueOf = String.valueOf(i2);
        if (i2 >= 1000000) {
            float f2 = i2 / 10000.0f;
            int i3 = i2 / 10000;
            if (f2 > i3) {
                return String.format("%.1f", Float.valueOf(f2));
            }
            return i3 + "";
        }
        return valueOf;
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        int indexOf;
        if (spannableString == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null || (indexOf = str.indexOf(str2)) < 0) {
            return;
        }
        spannableString.setSpan(characterStyle, indexOf, str2.length() + indexOf, 33);
    }
}
