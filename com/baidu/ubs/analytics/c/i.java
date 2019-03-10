package com.baidu.ubs.analytics.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.NetworkInterface;
import java.util.Collections;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class i {
    private static String A;
    private static String B;
    private static String z;

    public static String i(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.a(e);
            return "NA";
        }
    }

    public static int j(Context context) {
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || (state = networkInfo.getState()) == null || !(state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public static String k(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
            return deviceId == null ? "" : com.baidu.ubs.analytics.d.f.encode(deviceId);
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Context context) {
        String encode;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null && "02:00:00:00:00:00".equals(connectionInfo.getMacAddress())) {
            try {
                String rY = rY();
                if (rY != null) {
                    encode = com.baidu.ubs.analytics.d.f.encode(rY);
                } else {
                    encode = com.baidu.ubs.analytics.d.f.encode(a(wifiManager));
                }
                return encode;
            } catch (Exception e) {
                com.baidu.ubs.analytics.d.j.a(e);
                return com.baidu.ubs.analytics.d.f.encode("02:00:00:00:00:00");
            }
        } else if (connectionInfo != null && connectionInfo.getMacAddress() != null) {
            return com.baidu.ubs.analytics.d.f.encode(connectionInfo.getMacAddress());
        } else {
            return "";
        }
    }

    private static String rY() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.a(e);
        }
        return null;
    }

    private static String a(WifiManager wifiManager) throws Exception {
        String str;
        Exception e;
        FileInputStream fileInputStream;
        boolean z2 = 3 == wifiManager.getWifiState();
        try {
            wifiManager.setWifiEnabled(true);
            fileInputStream = new FileInputStream(new File("/sys/class/net/wlan0/address"));
            str = a(fileInputStream);
        } catch (Exception e2) {
            str = "";
            e = e2;
        }
        try {
            fileInputStream.close();
        } catch (Exception e3) {
            e = e3;
            com.baidu.ubs.analytics.d.j.a(e);
            wifiManager.setWifiEnabled(z2);
            return str;
        }
        wifiManager.setWifiEnabled(z2);
        return str;
    }

    private static String a(InputStream inputStream) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[2048];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HTTP.UTF_8));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static String m(Context context) {
        int i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.ubs.analytics.d.j.a(e);
        }
        return String.valueOf(i);
    }

    public static String n(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                return packageInfo.versionName == null ? "null" : packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.ubs.analytics.d.j.a(e);
        }
        return "";
    }

    public static String y() {
        if (TextUtils.isEmpty(z)) {
            p(com.baidu.ubs.analytics.d.csn().getContext());
        }
        return z;
    }

    public static String z() {
        if (TextUtils.isEmpty(A)) {
            p(com.baidu.ubs.analytics.d.csn().getContext());
        }
        return A;
    }

    public static String A() {
        if (TextUtils.isEmpty(B)) {
            p(com.baidu.ubs.analytics.d.csn().getContext());
        }
        return B;
    }

    private static void p(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        z = String.valueOf(displayMetrics.widthPixels);
        A = String.valueOf(displayMetrics.heightPixels);
        B = String.valueOf(displayMetrics.density);
    }

    public static String q(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.ubs.analytics.d.j.a(e);
            return null;
        }
    }
}
