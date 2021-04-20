package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f22647a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f22648b;

    public static void a(Context context) {
        f22648b = context;
        PackageManager packageManager = context.getPackageManager();
        f22647a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        PackageManager packageManager = f22647a;
        if (packageManager == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return packageManager.checkPermission(str, f22648b.getPackageName()) == 0;
        } catch (RuntimeException e2) {
            c.a("PermissionUtil#hasPermission failed.", e2);
            return false;
        }
    }
}
