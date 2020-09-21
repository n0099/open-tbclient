package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes21.dex */
public final class e {
    private static Context a;
    private static PackageManager b;
    private static PackageInfo c;

    public static String a() {
        return a == null ? "N/A" : a.getPackageName();
    }

    public static void a(Context context) {
        if (a == null) {
            a = context;
            b = context.getPackageManager();
            try {
                c = b.getPackageInfo(a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
