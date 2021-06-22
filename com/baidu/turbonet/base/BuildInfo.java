package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.turbonet.base.annotations.CalledByNative;
import d.a.p0.a.a;
/* loaded from: classes5.dex */
public class BuildInfo {
    @CalledByNative
    public static String getAndroidBuildFingerprint() {
        String str = Build.FINGERPRINT;
        return str.substring(0, Math.min(str.length(), 128));
    }

    @CalledByNative
    public static String getAndroidBuildId() {
        return Build.ID;
    }

    @CalledByNative
    public static String getBrand() {
        return Build.BRAND;
    }

    @CalledByNative
    public static String getBuildType() {
        return Build.TYPE;
    }

    @CalledByNative
    public static String getDevice() {
        return Build.DEVICE;
    }

    @CalledByNative
    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    @CalledByNative
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    @CalledByNative
    public static String getGMSVersionCode(Context context) {
        return "gms versionCode not available.";
    }

    @CalledByNative
    public static String getPackageLabel(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            PackageManager packageManager = context.getPackageManager();
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
            return applicationLabel != null ? applicationLabel.toString() : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @CalledByNative
    public static String getPackageName(Context context) {
        String packageName = context != null ? context.getPackageName() : null;
        return packageName != null ? packageName : "";
    }

    @CalledByNative
    public static String getPackageVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode > 0 ? Integer.toString(packageInfo.versionCode) : "";
        } catch (PackageManager.NameNotFoundException unused) {
            a.a("BuildInfo", "versionCode not available.");
            return "versionCode not available.";
        }
    }

    @CalledByNative
    public static String getPackageVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            a.a("BuildInfo", "versionName not available");
            return "versionName not available";
        }
    }

    @CalledByNative
    public static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }
}
