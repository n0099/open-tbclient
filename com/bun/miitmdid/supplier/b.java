package com.bun.miitmdid.supplier;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes6.dex */
public class b {

    /* loaded from: classes6.dex */
    public enum a {
        UNSUPPORT(-1, "unsupport"),
        HUA_WEI(0, "HUAWEI"),
        XIAOMI(1, "Xiaomi"),
        VIVO(2, RomUtils.MANUFACTURER_VIVO),
        OPPO(3, RomUtils.MANUFACTURER_OPPO),
        MOTO(4, "motorola"),
        LENOVO(5, "lenovo"),
        ASUS(6, "asus"),
        SAMSUNG(7, "samsung"),
        MEIZU(8, RomUtils.MANUFACTURER_MEIZU),
        ALPS(9, "alps"),
        NUBIA(10, RomUtils.MANUFACTURER_NUBIA);
        
        private int m;
        private String n;

        a(int i, String str) {
            this.m = i;
            this.n = str;
        }

        public static a a(String str) {
            a[] values;
            if (TextUtils.isEmpty(str)) {
                return UNSUPPORT;
            }
            for (a aVar : values()) {
                if (aVar.n.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return UNSUPPORT;
        }
    }
}
