package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes11.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes11.dex */
    private static final class a {
        private static final ag npS = new ag();
    }

    public static ag dQk() {
        return a.npS;
    }
}
