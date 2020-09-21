package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes21.dex */
public final class p {
    private static PackageManager a;
    private static Context b;

    public static void a(Context context) {
        b = context;
        PackageManager packageManager = context.getPackageManager();
        a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        if (a == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return a.checkPermission(str, b.getPackageName()) == 0;
        } catch (RuntimeException e) {
            c.a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
