package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static PackageManager f5673a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f5674b;

    public static void a(Context context) {
        f5674b = context;
        PackageManager packageManager = context.getPackageManager();
        f5673a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        if (f5673a == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return f5673a.checkPermission(str, f5674b.getPackageName()) == 0;
        } catch (RuntimeException e) {
            c.a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
