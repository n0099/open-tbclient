package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes19.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes19.dex */
    private static final class a {
        private static final ag oqT = new ag();
    }

    public static ag edv() {
        return a.oqT;
    }
}
