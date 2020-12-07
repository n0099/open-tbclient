package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes15.dex */
public class ai extends SharedPrefsWrapper {
    public ai() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes15.dex */
    private static final class a {
        private static final ai oHE = new ai();
    }

    public static ai ejh() {
        return a.oHE;
    }
}
