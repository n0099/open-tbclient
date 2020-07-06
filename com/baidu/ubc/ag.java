package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes13.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes13.dex */
    private static final class a {
        private static final ag mEw = new ag();
    }

    public static ag dxc() {
        return a.mEw;
    }
}
