package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22483a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22484b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22485c;

    public static String a() {
        Context context = f22483a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22483a == null) {
            f22483a = context;
            PackageManager packageManager = context.getPackageManager();
            f22484b = packageManager;
            try {
                f22485c = packageManager.getPackageInfo(f22483a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22485c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
