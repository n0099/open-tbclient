package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f28464a;

    /* renamed from: b  reason: collision with root package name */
    public static t f28465b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f28466c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f28467d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f28468e = null;

    public s() {
        if (d() == null) {
            f28465b = t.b();
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
        t tVar = f28465b;
        if (tVar != null) {
            tVar.a(str);
        }
        this.f28467d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        t tVar = f28465b;
        if (tVar != null) {
            tVar.b(str);
        }
        if (this.f28466c || d() == null) {
            return;
        }
        d().NM_reportNow(str);
        this.f28466c = true;
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f28468e)) {
                return this.f28468e;
            }
            String a2 = i.a("sdk_app_sha1", 2592000000L);
            this.f28468e = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.f28468e;
            }
            if (d() != null) {
                this.f28468e = d().NM_pullSg();
            } else if (f28465b != null) {
                this.f28468e = f28465b.c();
            }
            if (d(this.f28468e)) {
                String upperCase = this.f28468e.toUpperCase();
                this.f28468e = upperCase;
                i.a("sdk_app_sha1", upperCase);
                return this.f28468e;
            }
            String a3 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            this.f28468e = a3;
            if (d(a3)) {
                String upperCase2 = this.f28468e.toUpperCase();
                this.f28468e = upperCase2;
                i.a("sdk_app_sha1", upperCase2);
                return this.f28468e;
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
        if (f28464a == null) {
            synchronized (s.class) {
                if (f28464a == null) {
                    f28464a = new s();
                }
            }
        }
        return f28464a;
    }

    public String b() {
        t tVar = f28465b;
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
        t tVar = f28465b;
        return tVar != null ? tVar.c(str) : "";
    }
}
