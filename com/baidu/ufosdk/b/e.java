package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22606a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f22607b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f22608c;

    public static String a() {
        Context context = f22606a;
        return context == null ? "N/A" : context.getPackageName();
    }

    public static void a(Context context) {
        if (f22606a == null) {
            f22606a = context;
            PackageManager packageManager = context.getPackageManager();
            f22607b = packageManager;
            try {
                f22608c = packageManager.getPackageInfo(f22606a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        PackageInfo packageInfo = f22608c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }
}
