package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f28625a;

    /* renamed from: b  reason: collision with root package name */
    public static t f28626b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f28627c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f28628d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f28629e = null;

    public s() {
        if (d() == null) {
            f28626b = t.b();
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
        t tVar = f28626b;
        if (tVar != null) {
            tVar.a(str);
        }
        this.f28628d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        t tVar = f28626b;
        if (tVar != null) {
            tVar.b(str);
        }
        if (this.f28627c || d() == null) {
            return;
        }
        d().NM_reportNow(str);
        this.f28627c = true;
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f28629e)) {
                return this.f28629e;
            }
            String a2 = i.a("sdk_app_sha1", 2592000000L);
            this.f28629e = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.f28629e;
            }
            if (d() != null) {
                this.f28629e = d().NM_pullSg();
            } else if (f28626b != null) {
                this.f28629e = f28626b.c();
            }
            if (d(this.f28629e)) {
                String upperCase = this.f28629e.toUpperCase();
                this.f28629e = upperCase;
                i.a("sdk_app_sha1", upperCase);
                return this.f28629e;
            }
            String a3 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            this.f28629e = a3;
            if (d(a3)) {
                String upperCase2 = this.f28629e.toUpperCase();
                this.f28629e = upperCase2;
                i.a("sdk_app_sha1", upperCase2);
                return this.f28629e;
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
        if (f28625a == null) {
            synchronized (s.class) {
                if (f28625a == null) {
                    f28625a = new s();
                }
            }
        }
        return f28625a;
    }

    public String b() {
        t tVar = f28626b;
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
        t tVar = f28626b;
        return tVar != null ? tVar.c(str) : "";
    }
}
