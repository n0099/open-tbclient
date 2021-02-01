package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5362a;

    /* renamed from: b  reason: collision with root package name */
    private static PackageManager f5363b;
    private static PackageInfo c;

    public static String a() {
        return f5362a == null ? "N/A" : f5362a.getPackageName();
    }

    public static void a(Context context) {
        if (f5362a == null) {
            f5362a = context;
            f5363b = context.getPackageManager();
            try {
                c = f5363b.getPackageInfo(f5362a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
