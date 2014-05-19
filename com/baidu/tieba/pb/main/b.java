package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/page";
    private com.baidu.tbadk.core.util.al b = null;

    public String a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, boolean z3, long j, boolean z4, com.baidu.tieba.data.af afVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.b = new com.baidu.tbadk.core.util.al(a);
        this.b.a("kz", str);
        this.b.a("rn", String.valueOf(30));
        this.b.a("with_floor", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        int b = com.baidu.adp.lib.util.h.b(com.baidu.tieba.ad.c().d());
        int c = com.baidu.adp.lib.util.h.c(com.baidu.tieba.ad.c().d());
        float f = com.baidu.tieba.ad.c().d().getResources().getDisplayMetrics().density;
        int i6 = 1;
        if (com.baidu.tbadk.core.util.bf.a().d().equals("80")) {
            i6 = 2;
        }
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        this.b.a("q_type", String.valueOf(i6));
        if (!z) {
            this.b.a("r", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        if (z2) {
            this.b.a("lz", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        if (str2 != null) {
            this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
        }
        if (z3) {
            this.b.a("msg_click", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            this.b.a("message_id", String.valueOf(j));
        }
        if (afVar != null) {
            afVar.a(this.b);
        }
        switch (i3) {
            case 1:
                this.b.a("back", "0");
                if (!z4) {
                    if (!z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                } else if (!z) {
                    this.b.a("last", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                    break;
                }
                break;
            case 2:
                this.b.a("back", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                if (!z4) {
                    if (z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                }
                break;
            case 3:
                this.b.a("back", "0");
                if (z) {
                    this.b.a("pn", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                } else {
                    this.b.a("last", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                }
                if (z4) {
                    this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "store_thread");
                    break;
                }
                break;
            case 4:
                this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "store_thread");
                this.b.a("mark", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
            case 5:
                this.b.a("back", "0");
                this.b.a("pn", String.valueOf(i4));
                break;
            case 6:
                this.b.a("mark", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
        }
        return this.b.i();
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.a().b().b();
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

    public int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.b();
    }

    public String e() {
        if (this.b == null) {
            return null;
        }
        return this.b.f();
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d();
    }

    public long g() {
        if (this.b != null) {
            return this.b.a().c().a.d;
        }
        return 0L;
    }

    public long h() {
        if (this.b != null) {
            return this.b.a().c().a.c;
        }
        return 0L;
    }
}
