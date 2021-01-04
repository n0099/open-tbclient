package com.bun.miitmdid.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class sysParamters {
    private static volatile sysParamters pgu;

    /* renamed from: a  reason: collision with root package name */
    private String f6066a;

    /* renamed from: b  reason: collision with root package name */
    private String f6067b;
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
        PackageInfo a2 = a(context, context.getPackageName());
        if (a2 == null) {
            return null;
        }
        return a2.versionName;
    }

    public static sysParamters eoM() {
        if (pgu == null) {
            synchronized (sysParamters.class) {
                if (pgu == null) {
                    pgu = new sysParamters();
                }
            }
        }
        return pgu;
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
        if (TextUtils.isEmpty(this.f6066a)) {
            this.f6066a = a(b.a());
            return this.f6066a;
        }
        return this.f6066a;
    }

    public String c() {
        return this.sdk_version;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f6067b)) {
            this.f6067b = Build.MODEL;
            this.f6067b = this.f6067b.replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return this.f6067b;
        }
        return this.f6067b;
    }

    public String e() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = Uri.encode(Build.MANUFACTURER);
            return this.c;
        }
        return this.c;
    }
}
