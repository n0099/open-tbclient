package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5642a;

    /* renamed from: b  reason: collision with root package name */
    private static PackageManager f5643b;
    private static PackageInfo c;

    public static String a() {
        return f5642a == null ? "N/A" : f5642a.getPackageName();
    }

    public static void a(Context context) {
        if (f5642a == null) {
            f5642a = context;
            f5643b = context.getPackageManager();
            try {
                c = f5643b.getPackageInfo(f5642a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
