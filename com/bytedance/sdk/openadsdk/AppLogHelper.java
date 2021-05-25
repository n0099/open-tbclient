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
    public static volatile AppLogHelper f26942a;

    /* renamed from: b  reason: collision with root package name */
    public String f26943b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f26944c = null;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f26945d = false;

    private void a() {
        String g2 = a.g();
        this.f26943b = g2;
        if (TextUtils.isEmpty(g2)) {
            return;
        }
        i.a("sdk_app_log_did", this.f26943b);
    }

    private void b() {
        String n = a.n();
        this.f26944c = n;
        if (TextUtils.isEmpty(n)) {
            return;
        }
        i.a("app_log_user_unique_id", this.f26944c);
    }

    public static AppLogHelper getInstance() {
        if (f26942a == null) {
            synchronized (AppLogHelper.class) {
                if (f26942a == null) {
                    f26942a = new AppLogHelper();
                }
            }
        }
        return f26942a;
    }

    public String getAppLogDid() {
        if (TextUtils.isEmpty(this.f26943b)) {
            String a2 = i.a("sdk_app_log_did", 2592000000L);
            this.f26943b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f26945d) {
                    initAppLog(p.a());
                }
                a();
            }
        }
        return this.f26943b;
    }

    public String getAppLogUserUniqueID() {
        if (TextUtils.isEmpty(this.f26944c)) {
            String a2 = i.a("app_log_user_unique_id", 2592000000L);
            this.f26944c = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f26945d) {
                    initAppLog(p.a());
                }
                b();
            }
        }
        return this.f26944c;
    }

    public String getSdkVersion() {
        return !this.f26945d ? "" : (String) a.j("sdk_version_name", "");
    }

    public synchronized void initAppLog(Context context) {
        if (!this.f26945d) {
            q1 q1Var = new q1(String.valueOf(164362), "unionser_slardar_applog");
            if (m.f28189b != null) {
                q1Var.i(m.f28189b.isCanUsePhoneState());
                if (!m.f28189b.isCanUsePhoneState()) {
                    q1Var.e(m.f28189b.getDevImei());
                }
                q1Var.f(m.f28189b.isCanUseWifiState());
            }
            q1Var.d(new p1() { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                @Override // d.b.b.p1
                public String a() {
                    if (m.f28189b == null || m.f28189b.isCanUseWifiState()) {
                        return k.h(p.a());
                    }
                    return null;
                }
            });
            q1Var.a(0);
            a.o(context, q1Var);
            y.a(context);
            this.f26945d = true;
            a();
            b();
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (!this.f26945d) {
            initAppLog(p.a());
        }
        a.s(hashMap);
    }
}
