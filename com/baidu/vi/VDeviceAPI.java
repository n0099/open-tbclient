package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes20.dex */
public class VDeviceAPI {
    private static PowerManager.WakeLock a = null;
    private static BroadcastReceiver b = null;

    public static String getAppVersion() {
        try {
            return VIContext.getContext().getPackageManager().getPackageInfo(VIContext.getContext().getApplicationInfo().packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static long getAvailableMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) VIContext.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCellId() {
        TelephonyManager telephonyManager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        return cellLocation instanceof GsmCellLocation ? " " + ((GsmCellLocation) cellLocation).getCid() : " ";
    }

    public static String getCuid() {
        String str = "";
        SharedPreferences sharedPreferences = VIContext.getContext().getSharedPreferences("cuid", 0);
        if (sharedPreferences != null) {
            try {
                if (sharedPreferences.contains("cuid")) {
                    str = sharedPreferences.getString("cuid", "");
                }
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            sharedPreferences.edit().putString("cuid", str).commit();
        }
        return str;
    }

    public static int getCurrentNetworkType() {
        try {
            return Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
    }

    public static String getImei() {
        if (((TelephonyManager) VIContext.getContext().getSystemService("phone")) != null) {
        }
        return null;
    }

    public static String getImsi() {
        if (((TelephonyManager) VIContext.getContext().getSystemService("phone")) != null) {
        }
        return null;
    }

    public static String getLac() {
        TelephonyManager telephonyManager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        return cellLocation instanceof GsmCellLocation ? "" + ((GsmCellLocation) cellLocation).getLac() : "";
    }

    public static String getModuleFileName() {
        return VIContext.getContext().getFilesDir().getAbsolutePath();
    }

    public static VNetworkInfo getNetworkInfo(int i) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) VIContext.getContext().getSystemService("connectivity");
        switch (i) {
            case 2:
                networkInfo = connectivityManager.getNetworkInfo(1);
                break;
            case 3:
                networkInfo = connectivityManager.getNetworkInfo(0);
                break;
            default:
                networkInfo = null;
                break;
        }
        if (networkInfo != null) {
            return new VNetworkInfo(networkInfo);
        }
        return null;
    }

    public static String getOsVersion() {
        return "android";
    }

    @TargetApi(8)
    public static int getScreenBrightness() {
        ContentResolver contentResolver = VIContext.getContext().getContentResolver();
        int i = 0;
        if (8 <= Build.VERSION.SDK_INT) {
            try {
                i = Settings.System.getInt(contentResolver, "screen_brightness_mode");
            } catch (Exception e) {
            }
        }
        if (i == 1) {
            return -1;
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException e2) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.density;
    }

    public static int getScreenDensityDpi() {
        if (VIContext.getContext() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    public static long getSdcardFreeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
    }

    public static String getSdcardPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.getAbsolutePath();
        }
        return null;
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
    }

    public static float getSystemMetricsX() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (VIContext.getContext() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getTelecomInfo() {
        String subscriberId = ((TelephonyManager) VIContext.getContext().getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
                return 0;
            }
            if (subscriberId.startsWith("46001")) {
                return 1;
            }
            return subscriberId.startsWith("46003") ? 2 : -1;
        }
        return -1;
    }

    public static long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            r0 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : 0L;
            bufferedReader.close();
        } catch (IOException e) {
        }
        return r0;
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
    }

    public static ScanResult[] getWifiHotpot() {
        List<ScanResult> scanResults = ((WifiManager) VIContext.getContext().getApplicationContext().getSystemService("wifi")).getScanResults();
        return (ScanResult[]) scanResults.toArray(new ScanResult[scanResults.size()]);
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void makeCall(String str) {
        VIContext.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        VIContext.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        if (PhoneNumberUtils.isWellFormedSmsAddress(str)) {
            try {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("address", str);
                intent.putExtra("subject", str2);
                intent.putExtra("sms_body", str3);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + str4));
                intent.setType(mimeTypeFromExtension);
                VIContext.getContext().startActivity(intent);
                return 0;
            } catch (Exception e) {
                return 2;
            }
        }
        return 1;
    }

    public static void sendSMS(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        VIContext.getContext().startActivity(intent);
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        b = new e();
        VIContext.getContext().registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void setScreenAlwaysOn(boolean z) {
        if (z) {
            if (a == null) {
                a = ((PowerManager) VIContext.getContext().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
            }
            a.acquire();
        } else if (a == null || !a.isHeld()) {
        } else {
            a.release();
            a = null;
        }
    }

    public static void setupSoftware(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        VIContext.getContext().startActivity(intent);
    }

    public static void unsetNetworkChangedCallback() {
        if (b != null) {
            VIContext.getContext().unregisterReceiver(b);
            b = null;
        }
    }
}
