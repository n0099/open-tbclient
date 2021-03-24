package com.baidu.ufosdk.f;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static int f22956a;

    public static int a() {
        int i;
        if (f22956a == 0) {
            String str = Build.MODEL;
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            if (str != null) {
                str = str.toLowerCase();
            }
            if (str2 != null) {
                str2 = str2.toLowerCase();
            }
            if (str3 != null) {
                str3 = str3.toLowerCase();
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (str.contains(RomUtils.MANUFACTURER_XIAOMI) || str2.contains(RomUtils.MANUFACTURER_XIAOMI) || str3.contains(RomUtils.MANUFACTURER_XIAOMI)) {
                    i = 2;
                } else if (str.contains("samsung") || str2.contains("samsung") || str3.contains("samsung")) {
                    i = 3;
                } else if (str.contains(RomUtils.MANUFACTURER_HUAWEI) || str2.contains(RomUtils.MANUFACTURER_HUAWEI) || str3.contains(RomUtils.MANUFACTURER_HUAWEI)) {
                    i = 4;
                } else if (str.contains(RomUtils.MANUFACTURER_VIVO) || str2.contains(RomUtils.MANUFACTURER_VIVO) || str3.contains(RomUtils.MANUFACTURER_VIVO)) {
                    i = 5;
                } else if (str.contains(RomUtils.MANUFACTURER_OPPO) || str2.contains(RomUtils.MANUFACTURER_OPPO) || str3.contains(RomUtils.MANUFACTURER_OPPO)) {
                    i = 6;
                } else if (str.contains(RomUtils.MANUFACTURER_MEIZU) || str2.contains(RomUtils.MANUFACTURER_MEIZU) || str3.contains(RomUtils.MANUFACTURER_MEIZU)) {
                    i = 7;
                }
                f22956a = i;
            }
            f22956a = 1;
        }
        return f22956a;
    }
}
