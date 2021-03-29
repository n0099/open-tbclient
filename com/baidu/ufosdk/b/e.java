package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22913a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22914b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22915c;

    public static String a() {
        Context context = f22913a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22913a == null) {
            f22913a = context;
            PackageManager packageManager = context.getPackageManager();
            f22914b = packageManager;
            try {
                f22915c = packageManager.getPackageInfo(f22913a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22915c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
