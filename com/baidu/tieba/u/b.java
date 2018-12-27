package com.baidu.tieba.u;

import android.os.Build;
/* loaded from: classes.dex */
public class b {
    public static int wv(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return i;
    }
}
