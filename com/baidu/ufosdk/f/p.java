package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f23358a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f23359b;

    public static void a(Context context) {
        f23359b = context;
        PackageManager packageManager = context.getPackageManager();
        f23358a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        PackageManager packageManager = f23358a;
        if (packageManager == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return packageManager.checkPermission(str, f23359b.getPackageName()) == 0;
        } catch (RuntimeException e2) {
            c.a("PermissionUtil#hasPermission failed.", e2);
            return false;
        }
    }
}
