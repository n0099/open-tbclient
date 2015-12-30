package com.baidu.tieba.tbean;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class q {
    public static String np(int i) {
        float f;
        int i2;
        if (i < 0) {
            i = 0;
        }
        String valueOf = String.valueOf(i);
        if (i >= 1000000) {
            if (i / 10000.0f > i / 10000) {
                return String.valueOf(String.format("%.1f", Float.valueOf(f))) + TbadkCoreApplication.m411getInst().getResources().getString(n.j.tdou_unit);
            }
            return String.valueOf(i2) + TbadkCoreApplication.m411getInst().getResources().getString(n.j.tdou_unit);
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
