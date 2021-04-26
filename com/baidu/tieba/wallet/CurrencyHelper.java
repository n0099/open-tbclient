package com.baidu.tieba.wallet;

import com.baidu.tbadk.core.util.StringHelper;
/* loaded from: classes5.dex */
public class CurrencyHelper {
    public static String getFormatOverBaiwanNum(int i2, long j) {
        if (CurrencySwitchUtil.isYyIsConvert(i2)) {
            return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j));
        }
        return StringHelper.formatOverBaiwanNum(j);
    }

    public static float switchYFenToYBean(long j) {
        return ((float) j) / 100.0f;
    }

    public static String getFormatOverBaiwanNum(long j) {
        if (CurrencySwitchUtil.isYyIsConvert()) {
            return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j));
        }
        return StringHelper.formatOverBaiwanNum(j);
    }
}
