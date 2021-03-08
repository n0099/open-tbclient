package com.bytedance.sdk.openadsdk.core;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static t f4515a;
    private String d;
    private volatile boolean c = false;
    private com.pgl.sys.ces.d.b b = com.pgl.sys.ces.d.c.b(p.a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0, c());

    private t(String str) {
        this.d = null;
        this.d = str;
        if (!TextUtils.isEmpty(this.d)) {
            this.b.setParams(str, null);
        }
        if (i.d().f() != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("app_id", i.d().f());
            this.b.setCustomInfo(hashMap);
        }
    }

    private com.pgl.sys.ces.d.a c() {
        final TTCustomController e = i.d().e();
        return new com.pgl.sys.ces.d.a() { // from class: com.bytedance.sdk.openadsdk.core.t.1
            @Override // com.pgl.sys.ces.d.a
            public String getDeviceId() {
                return "";
            }

            @Override // com.pgl.sys.ces.d.a
            public String getSubscriberId() {
                if (e == null || e.isCanUsePhoneState()) {
                    return k.f(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public WifiInfo getConnectionInfo() {
                if (e == null || e.isCanUseWifiState()) {
                    WifiManager wifiManager = (WifiManager) p.a().getSystemService("wifi");
                    return wifiManager != null ? wifiManager.getConnectionInfo() : null;
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public List<ScanResult> getScanResults() {
                if (e == null || e.isCanUseWifiState()) {
                    WifiManager wifiManager = (WifiManager) p.a().getSystemService("wifi");
                    return wifiManager != null ? wifiManager.getScanResults() : null;
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public String getHardwareAddress() {
                if (e == null || e.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public String getLongitude() {
                if (e != null && !e.isCanUseLocation()) {
                    if (e.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(e.getTTLocation().getLongitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) != null) {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).b);
                } else {
                    return null;
                }
            }

            @Override // com.pgl.sys.ces.d.a
            public String getLatitude() {
                if (e != null && !e.isCanUseLocation()) {
                    if (e.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(e.getTTLocation().getLatitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) != null) {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).f5126a);
                } else {
                    return null;
                }
            }
        };
    }

    public String a() {
        return this.b.onEvent();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = str;
                this.b.setParams(this.d, null);
            }
            if (i.d().f() != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("app_id", i.d().f());
                this.b.setCustomInfo(hashMap);
            }
        }
    }

    public static t b(String str) {
        if (f4515a == null) {
            synchronized (t.class) {
                if (f4515a == null) {
                    f4515a = new t(str);
                }
            }
        }
        return f4515a;
    }

    public void c(@NonNull String str) {
        if (!this.c) {
            this.b.reportNow(str);
            this.c = true;
        }
    }

    public String b() {
        String str;
        try {
            String pullSg = this.b.pullSg();
            if (e(pullSg)) {
                str = pullSg.toUpperCase();
            } else {
                String a2 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
                if (e(a2)) {
                    str = a2.toUpperCase();
                } else {
                    str = "";
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    private boolean e(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String str2 : split) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return this.b.pullVer(a2);
    }
}
