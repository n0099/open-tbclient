package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static PackageManager f5393a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f5394b;

    public static void a(Context context) {
        f5394b = context;
        PackageManager packageManager = context.getPackageManager();
        f5393a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        if (f5393a == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return f5393a.checkPermission(str, f5394b.getPackageName()) == 0;
        } catch (RuntimeException e) {
            c.a("PermissionUtil#hasPermission failed.", e);
            return false;
        }
    }
}
