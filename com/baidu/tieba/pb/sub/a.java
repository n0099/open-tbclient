package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class a {
    private static final String a = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/pb/floor";
    private ak b = null;

    public final String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new ak(a);
        this.b.a().a().a = true;
        this.b.a("kz", str);
        com.baidu.tieba.r.c();
        int b = com.baidu.adp.lib.util.i.b(com.baidu.tieba.r.d());
        com.baidu.tieba.r.c();
        int c = com.baidu.adp.lib.util.i.c(com.baidu.tieba.r.d());
        com.baidu.tieba.r.c();
        float f = com.baidu.tieba.r.d().getResources().getDisplayMetrics().density;
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        switch (i) {
            case 0:
            case 2:
            case 3:
                this.b.a("pid", str3);
                this.b.a("pn", String.valueOf(i2));
                break;
            case 1:
                this.b.a("spid", str3);
                break;
        }
        return this.b.i();
    }

    public final boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.a().b().b();
    }

    public final String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.f();
    }

    public final int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d();
    }

    public final void d() {
        if (this.b != null) {
            this.b.g();
        }
        this.b = null;
    }
}
