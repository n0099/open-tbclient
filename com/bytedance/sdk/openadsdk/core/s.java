package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f28361a;

    /* renamed from: b  reason: collision with root package name */
    public static t f28362b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f28363c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f28364d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f28365e = null;

    public s() {
        if (d() == null) {
            f28362b = t.b();
        }
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

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t tVar = f28362b;
        if (tVar != null) {
            tVar.a(str);
        }
        this.f28364d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        t tVar = f28362b;
        if (tVar != null) {
            tVar.b(str);
        }
        if (this.f28363c || d() == null) {
            return;
        }
        d().NM_reportNow(str);
        this.f28363c = true;
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f28365e)) {
                return this.f28365e;
            }
            String a2 = i.a("sdk_app_sha1", 2592000000L);
            this.f28365e = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.f28365e;
            }
            if (d() != null) {
                this.f28365e = d().NM_pullSg();
            } else if (f28362b != null) {
                this.f28365e = f28362b.c();
            }
            if (d(this.f28365e)) {
                String upperCase = this.f28365e.toUpperCase();
                this.f28365e = upperCase;
                i.a("sdk_app_sha1", upperCase);
                return this.f28365e;
            }
            String a3 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            this.f28365e = a3;
            if (d(a3)) {
                String upperCase2 = this.f28365e.toUpperCase();
                this.f28365e = upperCase2;
                i.a("sdk_app_sha1", upperCase2);
                return this.f28365e;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private TTSecAbs d() {
        return i.d().p();
    }

    public static s a() {
        if (f28361a == null) {
            synchronized (s.class) {
                if (f28361a == null) {
                    f28361a = new s();
                }
            }
        }
        return f28361a;
    }

    public String b() {
        t tVar = f28362b;
        if (tVar != null) {
            String a2 = tVar.a();
            return a2.length() > 100 ? a2 : "";
        }
        return "";
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        if (d() != null) {
            return d().NM_pullVer(a2);
        }
        t tVar = f28362b;
        return tVar != null ? tVar.c(str) : "";
    }
}
