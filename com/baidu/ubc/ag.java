package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes13.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes13.dex */
    private static final class a {
        private static final ag lNZ = new ag();
    }

    public static ag dkO() {
        return a.lNZ;
    }
}
