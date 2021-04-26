package com.baidu.ufosdk.f;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static int f23353a;

    public static int a() {
        int i2;
        if (f23353a == 0) {
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
                    i2 = 2;
                } else if (str.contains(ManufacturerUtils.SAMSUNG) || str2.contains(ManufacturerUtils.SAMSUNG) || str3.contains(ManufacturerUtils.SAMSUNG)) {
                    i2 = 3;
                } else if (str.contains(RomUtils.MANUFACTURER_HUAWEI) || str2.contains(RomUtils.MANUFACTURER_HUAWEI) || str3.contains(RomUtils.MANUFACTURER_HUAWEI)) {
                    i2 = 4;
                } else if (str.contains(RomUtils.MANUFACTURER_VIVO) || str2.contains(RomUtils.MANUFACTURER_VIVO) || str3.contains(RomUtils.MANUFACTURER_VIVO)) {
                    i2 = 5;
                } else if (str.contains(RomUtils.MANUFACTURER_OPPO) || str2.contains(RomUtils.MANUFACTURER_OPPO) || str3.contains(RomUtils.MANUFACTURER_OPPO)) {
                    i2 = 6;
                } else if (str.contains("meizu") || str2.contains("meizu") || str3.contains("meizu")) {
                    i2 = 7;
                }
                f23353a = i2;
            }
            f23353a = 1;
        }
        return f23353a;
    }
}
