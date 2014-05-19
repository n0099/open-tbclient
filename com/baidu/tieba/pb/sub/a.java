package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.ad;
/* loaded from: classes.dex */
public class a {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/floor";
    private al b = null;

    public String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new al(a);
        this.b.a().a().a = true;
        this.b.a("kz", str);
        int b = com.baidu.adp.lib.util.h.b(ad.c().d());
        int c = com.baidu.adp.lib.util.h.c(ad.c().d());
        float f = ad.c().d().getResources().getDisplayMetrics().density;
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        if (str2 != null) {
            this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
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

    public boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.a().b().b();
    }

    public String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.f();
    }

    public int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d();
    }

    public void d() {
        if (this.b != null) {
            this.b.g();
        }
        this.b = null;
    }
}
