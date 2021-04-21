package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.y;
import d.c.b.a;
import d.c.b.p1;
import d.c.b.q1;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AppLogHelper {

    /* renamed from: a  reason: collision with root package name */
    public static volatile AppLogHelper f26950a;

    /* renamed from: b  reason: collision with root package name */
    public String f26951b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f26952c = null;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f26953d = false;

    private void a() {
        String g2 = a.g();
        this.f26951b = g2;
        if (TextUtils.isEmpty(g2)) {
            return;
        }
        i.a("sdk_app_log_did", this.f26951b);
    }

    private void b() {
        String n = a.n();
        this.f26952c = n;
        if (TextUtils.isEmpty(n)) {
            return;
        }
        i.a("app_log_user_unique_id", this.f26952c);
    }

    public static AppLogHelper getInstance() {
        if (f26950a == null) {
            synchronized (AppLogHelper.class) {
                if (f26950a == null) {
                    f26950a = new AppLogHelper();
                }
            }
        }
        return f26950a;
    }

    public String getAppLogDid() {
        if (TextUtils.isEmpty(this.f26951b)) {
            String a2 = i.a("sdk_app_log_did", 2592000000L);
            this.f26951b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f26953d) {
                    initAppLog(p.a());
                }
                a();
            }
        }
        return this.f26951b;
    }

    public String getAppLogUserUniqueID() {
        if (TextUtils.isEmpty(this.f26952c)) {
            String a2 = i.a("app_log_user_unique_id", 2592000000L);
            this.f26952c = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f26953d) {
                    initAppLog(p.a());
                }
                b();
            }
        }
        return this.f26952c;
    }

    public String getSdkVersion() {
        return !this.f26953d ? "" : (String) a.j("sdk_version_name", "");
    }

    public synchronized void initAppLog(Context context) {
        if (!this.f26953d) {
            q1 q1Var = new q1(String.valueOf(164362), "unionser_slardar_applog");
            if (m.f28153b != null) {
                q1Var.i(m.f28153b.isCanUsePhoneState());
                if (!m.f28153b.isCanUsePhoneState()) {
                    q1Var.e(m.f28153b.getDevImei());
                }
                q1Var.f(m.f28153b.isCanUseWifiState());
            }
            q1Var.d(new p1() { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                @Override // d.c.b.p1
                public String a() {
                    if (m.f28153b == null || m.f28153b.isCanUseWifiState()) {
                        return k.h(p.a());
                    }
                    return null;
                }
            });
            q1Var.a(0);
            a.o(context, q1Var);
            y.a(context);
            this.f26953d = true;
            a();
            b();
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (!this.f26953d) {
            initAppLog(p.a());
        }
        a.s(hashMap);
    }
}
