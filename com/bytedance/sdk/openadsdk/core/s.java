package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static s f4514a;
    private static t b;
    private volatile boolean c = false;
    private volatile boolean d;
    private String e;

    private s(String str) {
        this.d = false;
        this.e = null;
        this.e = str;
        if (c() == null) {
            b = t.b(str);
        } else if (!TextUtils.isEmpty(this.e)) {
            this.d = true;
            c().NM_setParams(this.e);
        }
    }

    public void a(String str) {
        if (b != null) {
            b.a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.e)) {
                this.e = str;
            }
            if (!this.d && c() != null) {
                this.d = true;
                c().NM_setParams(str);
            }
        }
    }

    public static s b(String str) {
        if (f4514a == null) {
            synchronized (s.class) {
                if (f4514a == null) {
                    f4514a = new s(str);
                }
            }
        }
        return f4514a;
    }

    public void c(@NonNull String str) {
        if (b != null) {
            b.c(str);
        }
        if (!this.c && c() != null) {
            c().NM_reportNow(str);
            this.c = true;
        }
    }

    public String a() {
        if (b != null) {
            String a2 = b.a();
            if (a2.length() > 100) {
                return a2;
            }
        }
        return "";
    }

    public String b() {
        String str = null;
        try {
            if (c() != null) {
                str = c().NM_pullSg();
            } else if (b != null) {
                str = b.b();
            }
            if (e(str)) {
                return str.toUpperCase();
            }
            String a2 = com.bytedance.sdk.openadsdk.utils.e.a(p.a());
            if (e(a2)) {
                return a2.toUpperCase();
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private boolean e(String str) {
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

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = com.bytedance.sdk.openadsdk.utils.j.a(str);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        if (c() != null) {
            return c().NM_pullVer(a2);
        }
        if (b != null) {
            return b.d(str);
        }
        return "";
    }

    private TTSecAbs c() {
        return i.d().n();
    }
}
