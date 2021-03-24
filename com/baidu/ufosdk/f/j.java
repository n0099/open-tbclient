package com.baidu.ufosdk.f;

import android.os.Build;
/* loaded from: classes5.dex */
public final class j {
    public static int a() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }
}
