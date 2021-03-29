package com.baidu.wallet.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class NetUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26854a = "NetUtils";

    public static JSONObject getConnectedWifi(Context context) {
        WifiManager wifiManager;
        if (context != null && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null && wifiManager.isWifiEnabled()) {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mac", connectionInfo.getBSSID());
                jSONObject.put("rssi", connectionInfo.getRssi());
                jSONObject.put("ssid", connectionInfo.getSSID());
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static JSONObject getWifiSig(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        try {
            jSONObject.put("cuid", str);
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                JSONObject jSONObject2 = new JSONObject();
                if (connectionInfo != null) {
                    jSONObject2.put("mac", connectionInfo.getBSSID());
                    jSONObject2.put("rssi", connectionInfo.getRssi());
                    jSONObject2.put("ssid", connectionInfo.getSSID());
                    jSONObject.put("wifi_conn", jSONObject2);
                }
                if (scanResults != null && scanResults.size() > 0) {
                    int i = 0;
                    JSONArray jSONArray = new JSONArray();
                    for (ScanResult scanResult : scanResults) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("mac", scanResult.BSSID);
                        jSONObject3.put("rssi", scanResult.level);
                        jSONObject3.put("ssid", scanResult.SSID);
                        jSONArray.put(jSONObject3);
                        i++;
                        if (i >= 10) {
                            break;
                        }
                    }
                    jSONObject.put("wifi_scan", jSONArray);
                } else {
                    jSONObject.put("wifi_scan", "");
                }
                return jSONObject;
            }
            jSONObject.put("wifi_conn", "");
            jSONObject.put("wifi_scan", "");
            return jSONObject;
        } catch (Exception e2) {
            LogUtil.e("NetUtils", "error", e2);
            return null;
        }
    }
}
