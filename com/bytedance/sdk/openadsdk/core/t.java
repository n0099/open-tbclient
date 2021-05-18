package com.bytedance.sdk.openadsdk.core;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static t f28437a;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f28439c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f28440d = null;

    /* renamed from: b  reason: collision with root package name */
    public d.m.b.b.d.b f28438b = d.m.b.b.d.c.a(p.a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0, d());

    public t() {
        if (TextUtils.isEmpty(i.d().g())) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Constants.APP_ID, i.d().g());
        this.f28438b.setCustomInfo(hashMap);
    }

    public static t b() {
        if (f28437a == null) {
            synchronized (t.class) {
                if (f28437a == null) {
                    f28437a = new t();
                }
            }
        }
        return f28437a;
    }

    private d.m.b.b.d.a d() {
        final TTCustomController e2 = i.d().e();
        return new d.m.b.b.d.a() { // from class: com.bytedance.sdk.openadsdk.core.t.1
            @Override // d.m.b.b.d.a
            public String a() {
                return "";
            }

            @Override // d.m.b.b.d.a
            public String b() {
                TTCustomController tTCustomController = e2;
                if (tTCustomController == null || tTCustomController.isCanUsePhoneState()) {
                    return k.f(p.a());
                }
                return null;
            }

            @Override // d.m.b.b.d.a
            public WifiInfo c() {
                WifiManager wifiManager;
                TTCustomController tTCustomController = e2;
                if ((tTCustomController == null || tTCustomController.isCanUseWifiState()) && (wifiManager = (WifiManager) p.a().getSystemService("wifi")) != null) {
                    return wifiManager.getConnectionInfo();
                }
                return null;
            }

            @Override // d.m.b.b.d.a
            public List<ScanResult> d() {
                WifiManager wifiManager;
                TTCustomController tTCustomController = e2;
                if ((tTCustomController == null || tTCustomController.isCanUseWifiState()) && (wifiManager = (WifiManager) p.a().getSystemService("wifi")) != null) {
                    return wifiManager.getScanResults();
                }
                return null;
            }

            @Override // d.m.b.b.d.a
            public String e() {
                TTCustomController tTCustomController = e2;
                if (tTCustomController == null || tTCustomController.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }

            @Override // d.m.b.b.d.a
            public String f() {
                TTCustomController tTCustomController = e2;
                if (tTCustomController != null && !tTCustomController.isCanUseLocation()) {
                    if (e2.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(e2.getTTLocation().getLongitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) == null) {
                    return null;
                } else {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).f30253b);
                }
            }

            @Override // d.m.b.b.d.a
            public String g() {
                TTCustomController tTCustomController = e2;
                if (tTCustomController != null && !tTCustomController.isCanUseLocation()) {
                    if (e2.getTTLocation() == null) {
                        return null;
                    }
                    return String.valueOf(e2.getTTLocation().getLatitude());
                } else if (com.bytedance.sdk.openadsdk.utils.d.a(p.a()) == null) {
                    return null;
                } else {
                    return String.valueOf(com.bytedance.sdk.openadsdk.utils.d.a(p.a()).f30252a);
                }
            }
        };
    }

    public String a() {
        return this.f28438b.onEvent();
    }

    public String c() {
        try {
            String pullSg = this.f28438b.pullSg();
            if (d(pullSg)) {
                return pullSg.toUpperCase();
            }
            String a2 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            return d(a2) ? a2.toUpperCase() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28440d = str;
        this.f28438b.setParams(str, null);
        if (TextUtils.isEmpty(i.d().g())) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Constants.APP_ID, i.d().g());
        this.f28438b.setCustomInfo(hashMap);
    }

    private boolean d(String str) {
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

    public void b(@NonNull String str) {
        if (this.f28439c) {
            return;
        }
        this.f28438b.reportNow(str);
        this.f28439c = true;
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        return TextUtils.isEmpty(a2) ? "" : this.f28438b.pullVer(a2);
    }
}
