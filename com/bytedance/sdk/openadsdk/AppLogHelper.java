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
    public static volatile AppLogHelper f27127a;

    /* renamed from: b  reason: collision with root package name */
    public String f27128b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f27129c = null;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f27130d = false;

    private void a() {
        String g2 = a.g();
        this.f27128b = g2;
        if (TextUtils.isEmpty(g2)) {
            return;
        }
        i.a("sdk_app_log_did", this.f27128b);
    }

    private void b() {
        String n = a.n();
        this.f27129c = n;
        if (TextUtils.isEmpty(n)) {
            return;
        }
        i.a("app_log_user_unique_id", this.f27129c);
    }

    public static AppLogHelper getInstance() {
        if (f27127a == null) {
            synchronized (AppLogHelper.class) {
                if (f27127a == null) {
                    f27127a = new AppLogHelper();
                }
            }
        }
        return f27127a;
    }

    public String getAppLogDid() {
        if (TextUtils.isEmpty(this.f27128b)) {
            String a2 = i.a("sdk_app_log_did", 2592000000L);
            this.f27128b = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f27130d) {
                    initAppLog(p.a());
                }
                a();
            }
        }
        return this.f27128b;
    }

    public String getAppLogUserUniqueID() {
        if (TextUtils.isEmpty(this.f27129c)) {
            String a2 = i.a("app_log_user_unique_id", 2592000000L);
            this.f27129c = a2;
            if (TextUtils.isEmpty(a2)) {
                if (!this.f27130d) {
                    initAppLog(p.a());
                }
                b();
            }
        }
        return this.f27129c;
    }

    public String getSdkVersion() {
        return !this.f27130d ? "" : (String) a.j("sdk_version_name", "");
    }

    public synchronized void initAppLog(Context context) {
        if (!this.f27130d) {
            q1 q1Var = new q1(String.valueOf(164362), "unionser_slardar_applog");
            if (m.f28374b != null) {
                q1Var.i(m.f28374b.isCanUsePhoneState());
                if (!m.f28374b.isCanUsePhoneState()) {
                    q1Var.e(m.f28374b.getDevImei());
                }
                q1Var.f(m.f28374b.isCanUseWifiState());
            }
            q1Var.d(new p1() { // from class: com.bytedance.sdk.openadsdk.AppLogHelper.1
                @Override // d.b.b.p1
                public String a() {
                    if (m.f28374b == null || m.f28374b.isCanUseWifiState()) {
                        return k.h(p.a());
                    }
                    return null;
                }
            });
            q1Var.a(0);
            a.o(context, q1Var);
            y.a(context);
            this.f27130d = true;
            a();
            b();
        }
    }

    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        if (!this.f27130d) {
            initAppLog(p.a());
        }
        a.s(hashMap);
    }
}
