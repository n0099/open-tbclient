package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes13.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes13.dex */
    private static final class a {
        private static final ag lNV = new ag();
    }

    public static ag dkR() {
        return a.lNV;
    }
}
