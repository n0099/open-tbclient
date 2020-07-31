package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes9.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes9.dex */
    private static final class a {
        private static final ag mMA = new ag();
    }

    public static ag dAp() {
        return a.mMA;
    }
}
