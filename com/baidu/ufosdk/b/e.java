package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5360a;

    /* renamed from: b  reason: collision with root package name */
    private static PackageManager f5361b;
    private static PackageInfo c;

    public static String a() {
        return f5360a == null ? "N/A" : f5360a.getPackageName();
    }

    public static void a(Context context) {
        if (f5360a == null) {
            f5360a = context;
            f5361b = context.getPackageManager();
            try {
                c = f5361b.getPackageInfo(f5360a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String b() {
        return c == null ? "N/A" : c.versionName;
    }
}
