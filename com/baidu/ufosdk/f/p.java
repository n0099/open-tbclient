package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f22717a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f22718b;

    public static void a(Context context) {
        f22718b = context;
        PackageManager packageManager = context.getPackageManager();
        f22717a = packageManager;
        if (packageManager == null) {
            c.d("PermissionUtil#init fail to get PackageManager.");
        }
    }

    public static boolean a(String str) {
        PackageManager packageManager = f22717a;
        if (packageManager == null) {
            c.d("PermissionUtil fail to get PackageManager.");
            return false;
        }
        try {
            return packageManager.checkPermission(str, f22718b.getPackageName()) == 0;
        } catch (RuntimeException e2) {
            c.a("PermissionUtil#hasPermission failed.", e2);
            return false;
        }
    }
}
