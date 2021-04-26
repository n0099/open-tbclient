package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f23309a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f23310b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f23311c;

    public static String a() {
        Context context = f23309a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f23309a == null) {
            f23309a = context;
            PackageManager packageManager = context.getPackageManager();
            f23310b = packageManager;
            try {
                f23311c = packageManager.getPackageInfo(f23309a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f23311c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
