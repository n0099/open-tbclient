package com.baidu.tieba.live.tbean;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tieba.live.tbean.data.SettingData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
/* loaded from: classes7.dex */
public class TBeanUtil {
    public static String formatTBeanNum(int i) {
        float f;
        if (i < 0) {
            i = 0;
        }
        String valueOf = String.valueOf(i);
        if (i >= 1000000) {
            int i2 = i / 10000;
            if (i / 10000.0f > i2) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
            }
            return i2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        }
        return valueOf;
    }

    public static String formatTBeanNum(long j) {
        float f;
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= TimeUtils.NANOS_PER_MS) {
            long j2 = j / 10000;
            if (((float) j) / 10000.0f > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        }
        return valueOf;
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        int indexOf;
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && characterStyle != null && (indexOf = str.indexOf(str2)) >= 0) {
            spannableString.setSpan(characterStyle, indexOf, str2.length() + indexOf, 33);
        }
    }

    public static int getYuanFromFen(int i) {
        return (int) (i / 100.0f);
    }

    public static int getTBeanNum(UserInfoData userInfoData, int i, SettingData settingData) {
        if (userInfoData == null) {
            return 0;
        }
        return userInfoData.is_mem == 2 ? (settingData == null || settingData.vip_extra_switch != 1 || settingData.vip_extra_percent <= 0) ? i : ((settingData.vip_extra_percent * i) / 100) + i : i;
    }
}
