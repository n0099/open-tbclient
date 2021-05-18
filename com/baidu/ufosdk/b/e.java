package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22554a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22555b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22556c;

    public static String a() {
        Context context = f22554a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22554a == null) {
            f22554a = context;
            PackageManager packageManager = context.getPackageManager();
            f22555b = packageManager;
            try {
                f22556c = packageManager.getPackageInfo(f22554a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22556c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
