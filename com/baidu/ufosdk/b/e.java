package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22586a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22587b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22588c;

    public static String a() {
        Context context = f22586a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22586a == null) {
            f22586a = context;
            PackageManager packageManager = context.getPackageManager();
            f22587b = packageManager;
            try {
                f22588c = packageManager.getPackageInfo(f22586a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22588c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
