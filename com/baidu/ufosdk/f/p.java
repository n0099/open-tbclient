package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes22.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static PackageManager f3725a;
    private static Context b;

    public static void a(Context context) {
        b = context;
        PackageManager packageManager = context.getPackageManager();
        f3725a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        if (f3725a == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return f3725a.checkPermission(str, b.getPackageName()) == 0;
        } catch (RuntimeException e) {
            c.a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
