package com.baidu.tieba.tbean;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class b {
    public static String formatTBeanNum(int i) {
        float f;
        if (i < 0) {
            i = 0;
        }
        String valueOf = String.valueOf(i);
        if (i >= 1000000) {
            int i2 = i / 10000;
            if (i / 10000.0f > i2) {
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return i2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
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
                return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        }
        return valueOf;
    }

    public static int getYuanFromFen(int i) {
        return (int) (i / 100.0f);
    }

    public static int a(UserInfo userInfo, int i, Setting setting) {
        if (userInfo == null || userInfo.is_mem == null) {
            return 0;
        }
        return userInfo.is_mem.intValue() == 2 ? (setting == null || setting.vip_extra_switch.intValue() != 1 || setting.vip_extra_percent.intValue() <= 0) ? i : ((setting.vip_extra_percent.intValue() * i) / 100) + i : i;
    }
}
