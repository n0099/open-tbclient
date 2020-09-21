package com.baidu.tieba.live.tbean;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
/* loaded from: classes4.dex */
public class BuyTBeanStringUlti {
    public static String formatTBeanNum(int i) {
        float f;
        if (i < 0) {
            i = 0;
        }
        String valueOf = String.valueOf(i);
        if (i >= 1000000) {
            int i2 = i / 10000;
            return i / 10000.0f > ((float) i2) ? String.format("%.1f", Float.valueOf(f)) + "万" : i2 + "万";
        }
        return valueOf;
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        int indexOf;
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null && (indexOf = str.indexOf(str2)) >= 0) {
            spannableString.setSpan(characterStyle, indexOf, str2.length() + indexOf, 33);
        }
    }
}
