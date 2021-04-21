package com.bun.miitmdid.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
/* loaded from: classes5.dex */
public class sysParamters {

    /* renamed from: e  reason: collision with root package name */
    public static volatile sysParamters f26843e;

    /* renamed from: a  reason: collision with root package name */
    public String f26844a;

    /* renamed from: b  reason: collision with root package name */
    public String f26845b;

    /* renamed from: c  reason: collision with root package name */
    public String f26846c;

    /* renamed from: d  reason: collision with root package name */
    public String f26847d = "Android";
    @Keep
    public String sdk_version = "10011";
    @Keep
    public String sdk_vname = "1.0.11";

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static sysParamters a() {
        if (f26843e == null) {
            synchronized (sysParamters.class) {
                if (f26843e == null) {
                    f26843e = new sysParamters();
                }
            }
        }
        return f26843e;
    }

    public static String a(Context context) {
        if (context == null) {
            return "0.1.100";
        }
        PackageInfo a2 = a(context, context.getPackageName());
        if (a2 == null) {
            return null;
        }
        return a2.versionName;
    }

    public static String f() {
        return "";
    }

    public static String g() {
        ApplicationInfo applicationInfo = b.a().getApplicationInfo();
        return (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) ? h() : applicationInfo.packageName;
    }

    public static String h() {
        return b.a().getPackageName();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f26844a)) {
            String a2 = a(b.a());
            this.f26844a = a2;
            return a2;
        }
        return this.f26844a;
    }

    public String c() {
        return this.sdk_version;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f26845b)) {
            String str = Build.MODEL;
            this.f26845b = str;
            String replace = str.replace(" ", "-");
            this.f26845b = replace;
            return replace;
        }
        return this.f26845b;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f26846c)) {
            String encode = Uri.encode(Build.MANUFACTURER);
            this.f26846c = encode;
            return encode;
        }
        return this.f26846c;
    }
}
