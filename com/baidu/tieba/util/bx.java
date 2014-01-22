package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class bx {
    private static bx a = null;
    private boolean b = false;
    private boolean c = false;
    private int d = 600;
    private String e = String.valueOf(45);

    public static bx a() {
        if (a == null) {
            synchronized (bx.class) {
                a = new bx();
            }
        }
        return a;
    }

    public bx() {
        j();
        i();
    }

    private void i() {
        f();
        g();
        h();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.b = z;
        i();
    }

    private void j() {
        this.b = UtilHelper.g(TiebaApplication.h().getApplicationContext()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    public boolean c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        h();
        return this.d;
    }

    public void f() {
        boolean z = true;
        if (com.baidu.tieba.e.a.a().g() != 0 ? com.baidu.tieba.e.a.a().g() != 1 : !this.b) {
            z = false;
        }
        a(z);
    }

    public void g() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tieba.e.a.a().g() == 0) {
            if (c()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tieba.e.a.a().g() == 1) {
            valueOf = String.valueOf(80);
        }
        this.e = valueOf;
    }

    public void h() {
        int i = 900;
        switch (com.baidu.tieba.e.a.a().e()) {
            case 0:
                if (!c()) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 750;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 750;
                break;
        }
        this.d = i;
    }
}
