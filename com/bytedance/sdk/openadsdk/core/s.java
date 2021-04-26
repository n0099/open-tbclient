package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes5.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f29187a;

    /* renamed from: b  reason: collision with root package name */
    public static t f29188b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f29189c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f29190d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f29191e = null;

    public s() {
        if (d() == null) {
            f29188b = t.b();
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
        t tVar = f29188b;
        if (tVar != null) {
            tVar.a(str);
        }
        this.f29190d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        t tVar = f29188b;
        if (tVar != null) {
            tVar.b(str);
        }
        if (this.f29189c || d() == null) {
            return;
        }
        d().NM_reportNow(str);
        this.f29189c = true;
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f29191e)) {
                return this.f29191e;
            }
            String a2 = i.a("sdk_app_sha1", 2592000000L);
            this.f29191e = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.f29191e;
            }
            if (d() != null) {
                this.f29191e = d().NM_pullSg();
            } else if (f29188b != null) {
                this.f29191e = f29188b.c();
            }
            if (d(this.f29191e)) {
                String upperCase = this.f29191e.toUpperCase();
                this.f29191e = upperCase;
                i.a("sdk_app_sha1", upperCase);
                return this.f29191e;
            }
            String a3 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            this.f29191e = a3;
            if (d(a3)) {
                String upperCase2 = this.f29191e.toUpperCase();
                this.f29191e = upperCase2;
                i.a("sdk_app_sha1", upperCase2);
                return this.f29191e;
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
        if (f29187a == null) {
            synchronized (s.class) {
                if (f29187a == null) {
                    f29187a = new s();
                }
            }
        }
        return f29187a;
    }

    public String b() {
        t tVar = f29188b;
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
        t tVar = f29188b;
        return tVar != null ? tVar.c(str) : "";
    }
}
