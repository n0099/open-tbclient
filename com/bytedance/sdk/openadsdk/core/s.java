package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTSecAbs;
/* loaded from: classes4.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static s f6977a;

    /* renamed from: b  reason: collision with root package name */
    private static t f6978b;
    private volatile boolean c = false;
    private volatile boolean d;
    private String e;

    private s(String str) {
        this.d = false;
        this.e = null;
        this.e = str;
        if (b() == null) {
            f6978b = t.b(str);
        } else if (!TextUtils.isEmpty(this.e)) {
            this.d = true;
            b().NM_setParams(this.e);
        }
    }

    public void a(String str) {
        if (f6978b != null) {
            f6978b.a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.e)) {
                this.e = str;
            }
            if (!this.d && b() != null) {
                this.d = true;
                b().NM_setParams(str);
            }
        }
    }

    public static s b(String str) {
        if (f6977a == null) {
            synchronized (s.class) {
                if (f6977a == null) {
                    f6977a = new s(str);
                }
            }
        }
        return f6977a;
    }

    public void c(@NonNull String str) {
        if (f6978b != null) {
            f6978b.c(str);
        }
        if (!this.c && b() != null) {
            b().NM_reportNow(str);
            this.c = true;
        }
    }

    public String a() {
        String str = null;
        try {
            if (b() != null) {
                str = b().NM_pullSg();
            } else if (f6978b != null) {
                str = f6978b.a();
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
        if (b() != null) {
            return b().NM_pullVer(a2);
        }
        if (f6978b != null) {
            return f6978b.d(str);
        }
        return "";
    }

    private TTSecAbs b() {
        return i.c().m();
    }
}
