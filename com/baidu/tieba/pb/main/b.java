package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
public final class b {
    private static final String a = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/pb/page";
    private com.baidu.tbadk.core.util.ak b = null;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, boolean z3, long j, boolean z4, com.baidu.tieba.data.af afVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.b = new com.baidu.tbadk.core.util.ak(a);
        this.b.a("kz", str);
        this.b.a("rn", String.valueOf(30));
        this.b.a("with_floor", "1");
        com.baidu.tieba.r.c();
        int b = com.baidu.adp.lib.util.i.b(com.baidu.tieba.r.d());
        com.baidu.tieba.r.c();
        int c = com.baidu.adp.lib.util.i.c(com.baidu.tieba.r.d());
        com.baidu.tieba.r.c();
        float f = com.baidu.tieba.r.d().getResources().getDisplayMetrics().density;
        int i6 = 1;
        if (com.baidu.tbadk.core.util.bd.a().d().equals("80")) {
            i6 = 2;
        }
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        this.b.a("q_type", String.valueOf(i6));
        if (!z) {
            this.b.a("r", "1");
        }
        if (z2) {
            this.b.a("lz", "1");
        }
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        if (z3) {
            this.b.a("msg_click", "1");
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
                    this.b.a("last", "1");
                    break;
                }
                break;
            case 2:
                this.b.a("back", "1");
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
                    this.b.a("pn", "1");
                } else {
                    this.b.a("last", "1");
                }
                if (z4) {
                    this.b.a("st_type", "store_thread");
                    break;
                }
                break;
            case 4:
                this.b.a("st_type", "store_thread");
                this.b.a("mark", "1");
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
            case 5:
                this.b.a("back", "0");
                this.b.a("pn", String.valueOf(i4));
                break;
            case 6:
                this.b.a("mark", "1");
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
        }
        return this.b.i();
    }

    public final void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public final boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.a().b().b();
    }

    public final boolean c() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

    public final int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.b();
    }

    public final String e() {
        if (this.b == null) {
            return null;
        }
        return this.b.f();
    }

    public final int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d();
    }

    public final long g() {
        if (this.b != null) {
            return this.b.a().c().a.d;
        }
        return 0L;
    }

    public final long h() {
        if (this.b != null) {
            return this.b.a().c().a.c;
        }
        return 0L;
    }
}
