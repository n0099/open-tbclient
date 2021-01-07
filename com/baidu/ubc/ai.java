package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes6.dex */
public class ai extends SharedPrefsWrapper {
    public ai() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes6.dex */
    private static final class a {
        private static final ai oNP = new ai();
    }

    public static ai ejt() {
        return a.oNP;
    }
}
