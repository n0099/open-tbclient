package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.y;
import d.b.b.a;
import d.b.b.p1;
import d.b.b.q1;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class AppLogHelper {

    /* renamed from: a  reason: collision with root package name */
    public static volatile AppLogHelper f27013a;

    /* renamed from: b  reason: collision with root package name */
    public String f27014b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f27015c = null;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f27016d = false;

    private void a() {
        String g2 = a.g();
        this.f27014b = g2;
        if (TextUtils.isEmpty(g2)) {
            return;
        }
        i.a("sdk_app_log_did", this.f27014b);
    }

    private void b() {
        String n = a.n();
        this.f27015c = n;
        if (TextUtils.isEmpty(n)) {
            return;
        }
        i.a("app_log_user_unique_id", this.f27015c);
    }

    public static AppLogHelper getInstance() {
        if (f27013a == null) {
            synchronized (AppLogHelper.class) {
                if (f27013a == null) {
                    f27013a = new AppLogHelper();
                }
            }
        }
        return f27013a;
    }

    public String getAppLogDid() {
        if (TextUtils.isEmpty(this.f27014b)) {
            String a2 = i.a("sdk_app_log_did", 2592000000L);
            this.f27014b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f27016d) {
                    initAppLog(p.a());
                }
                a();
            }
        }
        return this.f27014b;
    }

    public String getAppLogUserUniqueID() {
        if (TextUtils.isEmpty(this.f27015c)) {
            String a2 = i.a("app_log_user_unique_id", 2592000000L);
            this.f27015c = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f27016d) {
                    initAppLog(p.a());
                }
                b();
            }
        }
        return this.f27015c;
    }

    public String getSdkVersion() {
        return !this.f27016d ? "" : (String) a.j("sdk_version_name", "");
    }

    public synchronized void initAppLog(Context context) {
        if (!this.f27016d) {
            q1 q1Var = new q1(String.valueOf(164362), "unionser_slardar_applog");
            if (m.f28260b != null) {
                q1Var.i(m.f28260b.isCanUsePhoneState());
                if (!m.f28260b.isCanUsePhoneState()) {
                    q1Var.e(m.f28260b.getDevImei());
                }
                q1Var.f(m.f28260b.isCanUseWifiState());
            }
            q1Var.d(new p1() { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                @Override // d.b.b.p1
                public String a() {
                    if (m.f28260b == null || m.f28260b.isCanUseWifiState()) {
                        return k.h(p.a());
                    }
                    return null;
                }
            });
            q1Var.a(0);
            a.o(context, q1Var);
            y.a(context);
            this.f27016d = true;
            a();
            b();
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (!this.f27016d) {
            initAppLog(p.a());
        }
        a.s(hashMap);
    }
}
