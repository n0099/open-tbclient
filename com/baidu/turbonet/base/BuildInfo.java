package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes15.dex */
public class BuildInfo {
    private BuildInfo() {
    }

    @CalledByNative
    public static String getDevice() {
        return Build.DEVICE;
    }

    @CalledByNative
    public static String getBrand() {
        return Build.BRAND;
    }

    @CalledByNative
    public static String getAndroidBuildId() {
        return Build.ID;
    }

    @CalledByNative
    public static String getAndroidBuildFingerprint() {
        return Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
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
    public static String getPackageVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionCode <= 0) {
                return "";
            }
            return Integer.toString(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            a.d("BuildInfo", "versionCode not available.");
            return "versionCode not available.";
        }
    }

    @CalledByNative
    public static String getPackageVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            a.d("BuildInfo", "versionName not available");
            return "versionName not available";
        }
    }

    @CalledByNative
    public static String getPackageLabel(Context context) {
        String str;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            PackageManager packageManager = context.getPackageManager();
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
            str = applicationLabel != null ? applicationLabel.toString() : "";
        } catch (PackageManager.NameNotFoundException e) {
            str = "";
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        return str;
    }

    @CalledByNative
    public static String getPackageName(Context context) {
        String packageName = context != null ? context.getPackageName() : null;
        return packageName != null ? packageName : "";
    }

    @CalledByNative
    public static String getBuildType() {
        return Build.TYPE;
    }

    @CalledByNative
    public static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }
}
