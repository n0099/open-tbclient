package com.baidu.ufosdk.f;

import android.os.Build;
/* loaded from: classes21.dex */
public final class j {
    public static int a() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (IllegalAccessException e) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (IllegalArgumentException e2) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NoSuchFieldException e3) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (SecurityException e4) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }
}
