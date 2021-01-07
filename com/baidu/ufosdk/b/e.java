package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5643a;

    /* renamed from: b  reason: collision with root package name */
    private static PackageManager f5644b;
    private static PackageInfo c;

    public static String a() {
        return f5643a == null ? "N/A" : f5643a.getPackageName();
    }

    public static void a(Context context) {
        if (f5643a == null) {
            f5643a = context;
            f5644b = context.getPackageManager();
            try {
                c = f5644b.getPackageInfo(f5643a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
