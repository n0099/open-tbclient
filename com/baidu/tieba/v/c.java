package com.baidu.tieba.v;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static int EM(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return i;
    }
}
