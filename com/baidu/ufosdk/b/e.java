package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22668a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22669b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22670c;

    public static String a() {
        Context context = f22668a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22668a == null) {
            f22668a = context;
            PackageManager packageManager = context.getPackageManager();
            f22669b = packageManager;
            try {
                f22670c = packageManager.getPackageInfo(f22668a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22670c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
