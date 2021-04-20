package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes5.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f28310a;

    /* renamed from: b  reason: collision with root package name */
    public static t f28311b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f28312c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f28313d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f28314e = null;

    public s() {
        if (d() == null) {
            f28311b = t.b();
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
        t tVar = f28311b;
        if (tVar != null) {
            tVar.a(str);
        }
        this.f28313d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        t tVar = f28311b;
        if (tVar != null) {
            tVar.b(str);
        }
        if (this.f28312c || d() == null) {
            return;
        }
        d().NM_reportNow(str);
        this.f28312c = true;
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f28314e)) {
                return this.f28314e;
            }
            String a2 = i.a("sdk_app_sha1", 2592000000L);
            this.f28314e = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.f28314e;
            }
            if (d() != null) {
                this.f28314e = d().NM_pullSg();
            } else if (f28311b != null) {
                this.f28314e = f28311b.c();
            }
            if (d(this.f28314e)) {
                String upperCase = this.f28314e.toUpperCase();
                this.f28314e = upperCase;
                i.a("sdk_app_sha1", upperCase);
                return this.f28314e;
            }
            String a3 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            this.f28314e = a3;
            if (d(a3)) {
                String upperCase2 = this.f28314e.toUpperCase();
                this.f28314e = upperCase2;
                i.a("sdk_app_sha1", upperCase2);
                return this.f28314e;
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
        if (f28310a == null) {
            synchronized (s.class) {
                if (f28310a == null) {
                    f28310a = new s();
                }
            }
        }
        return f28310a;
    }

    public String b() {
        t tVar = f28311b;
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
        t tVar = f28311b;
        return tVar != null ? tVar.c(str) : "";
    }
}
