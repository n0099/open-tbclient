package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes15.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes15.dex */
    private static final class a {
        private static final ag osx = new ag();
    }

    public static ag edu() {
        return a.osx;
    }
}
