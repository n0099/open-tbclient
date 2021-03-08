package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3609a;
    private static PackageManager b;
    private static PackageInfo c;

    public static String a() {
        return f3609a == null ? "N/A" : f3609a.getPackageName();
    }

    public static void a(Context context) {
        if (f3609a == null) {
            f3609a = context;
            b = context.getPackageManager();
            try {
                c = b.getPackageInfo(f3609a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
