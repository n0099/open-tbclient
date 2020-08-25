package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes18.dex */
public class ag extends SharedPrefsWrapper {
    public ag() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes18.dex */
    private static final class a {
        private static final ag nfy = new ag();
    }

    public static ag dMd() {
        return a.nfy;
    }
}
