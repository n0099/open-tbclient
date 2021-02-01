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
    private static t f6681a;
    private String d;
    private volatile boolean c = false;

    /* renamed from: b  reason: collision with root package name */
    private com.pgl.sys.ces.d.b f6682b = com.pgl.sys.ces.d.c.b(p.a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0, b());

    private t(String str) {
        this.d = null;
        this.d = str;
        if (!TextUtils.isEmpty(this.d)) {
            this.f6682b.setParams(str, null);
        }
        if (i.c().e() != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("app_id", i.c().e());
            this.f6682b.setCustomInfo(hashMap);
        }
    }

    private com.pgl.sys.ces.d.a b() {
        final TTCustomController d = i.c().d();
        return new com.pgl.sys.ces.d.a() { // from class: com.bytedance.sdk.openadsdk.core.t.1
            @Override // com.pgl.sys.ces.d.a
            public String getDeviceId() {
                return "";
            }

            @Override // com.pgl.sys.ces.d.a
            public String getSubscriberId() {
                if (d == null || d.isCanUsePhoneState()) {
                    return k.f(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public WifiInfo getConnectionInfo() {
                if (d == null || d.isCanUseWifiState()) {
                    WifiManager wifiManager = (WifiManager) p.a().getSystemService("wifi");
                    return wifiManager != null ? wifiManager.getConnectionInfo() : null;
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public List<ScanResult> getScanResults() {
                if (d == null || d.isCanUseWifiState()) {
                    WifiManager wifiManager = (WifiManager) p.a().getSystemService("wifi");
                    return wifiManager != null ? wifiManager.getScanResults() : null;
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public String getHardwareAddress() {
                if (d == null || d.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }

            @Override // com.pgl.sys.ces.d.a
            public String getLongitude() {
                if (d != null && !d.isCanUseLocation()) {
                    if (d.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(d.getTTLocation().getLongitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) != null) {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).f7567b);
                } else {
                    return null;
                }
            }

            @Override // com.pgl.sys.ces.d.a
            public String getLatitude() {
                if (d != null && !d.isCanUseLocation()) {
                    if (d.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(d.getTTLocation().getLatitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) != null) {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).f7566a);
                } else {
                    return null;
                }
            }
        };
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = str;
                this.f6682b.setParams(this.d, null);
            }
            if (i.c().e() != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("app_id", i.c().e());
                this.f6682b.setCustomInfo(hashMap);
            }
        }
    }

    public static t b(String str) {
        if (f6681a == null) {
            synchronized (t.class) {
                if (f6681a == null) {
                    f6681a = new t(str);
                }
            }
        }
        return f6681a;
    }

    public void c(@NonNull String str) {
        if (!this.c) {
            this.f6682b.reportNow(str);
            this.c = true;
        }
    }

    public String a() {
        String str;
        try {
            String pullSg = this.f6682b.pullSg();
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
        return this.f6682b.pullVer(a2);
    }
}
