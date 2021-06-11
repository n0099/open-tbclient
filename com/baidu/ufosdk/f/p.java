package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f22635a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f22636b;

    public static void a(Context context) {
        f22636b = context;
        PackageManager packageManager = context.getPackageManager();
        f22635a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        PackageManager packageManager = f22635a;
        if (packageManager == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return packageManager.checkPermission(str, f22636b.getPackageName()) == 0;
        } catch (RuntimeException e2) {
            c.a("PermissionUtil#hasPermission failed.", e2);
            return false;
        }
    }
}
