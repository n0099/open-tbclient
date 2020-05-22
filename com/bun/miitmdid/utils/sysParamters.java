package com.bun.miitmdid.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class sysParamters {
    private static volatile sysParamters mjP;
    private String a;
    private String b;
    private String c;
    private String d = "Android";
    @Keep
    private String sdk_version = "10011";
    @Keep
    private String sdk_vname = "1.0.11";

    private sysParamters() {
    }

    private static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return "0.1.100";
        }
        PackageInfo a = a(context, context.getPackageName());
        if (a == null) {
            return null;
        }
        return a.versionName;
    }

    public static sysParamters dth() {
        if (mjP == null) {
            synchronized (sysParamters.class) {
                if (mjP == null) {
                    mjP = new sysParamters();
                }
            }
        }
        return mjP;
    }

    public static String f() {
        return "";
    }

    public static String g() {
        ApplicationInfo applicationInfo = b.a().getApplicationInfo();
        return (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) ? h() : applicationInfo.packageName;
    }

    private static String h() {
        return b.a().getPackageName();
    }

    public String b() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = a(b.a());
            return this.a;
        }
        return this.a;
    }

    public String c() {
        return this.sdk_version;
    }

    public String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = Build.MODEL;
            this.b = this.b.replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return this.b;
        }
        return this.b;
    }

    public String e() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = Uri.encode(Build.MANUFACTURER);
            return this.c;
        }
        return this.c;
    }
}
