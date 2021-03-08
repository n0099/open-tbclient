package com.baidu.ubc;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes5.dex */
public class ai extends SharedPrefsWrapper {
    public ai() {
        super("com.baidu.searchbox_ubc");
    }

    /* loaded from: classes5.dex */
    private static final class a {
        private static final ai oVY = new ai();
    }

    public static ai eij() {
        return a.oVY;
    }
}
