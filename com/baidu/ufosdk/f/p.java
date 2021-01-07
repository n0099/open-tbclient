package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static PackageManager f5674a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f5675b;

    public static void a(Context context) {
        f5675b = context;
        PackageManager packageManager = context.getPackageManager();
        f5674a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        if (f5674a == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return f5674a.checkPermission(str, f5675b.getPackageName()) == 0;
        } catch (RuntimeException e) {
            c.a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
