package com.baidu.tieba.util;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private static bd f2439a = null;
    private boolean b = false;
    private boolean c = false;
    private int d = 600;
    private String e = String.valueOf(45);

    public static bd a() {
        if (f2439a == null) {
            synchronized (bd.class) {
                f2439a = new bd();
            }
        }
        return f2439a;
    }

    public bd() {
        h();
        g();
    }

    private void g() {
        i();
        j();
        f();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.b = z;
        g();
    }

    private void h() {
        this.b = UtilHelper.i(TiebaApplication.g().getApplicationContext()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    public boolean c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        f();
        return this.d;
    }

    private void i() {
        boolean z = true;
        if (TiebaApplication.g().am() != 0 ? TiebaApplication.g().am() != 1 : !this.b) {
            z = false;
        }
        a(z);
    }

    private void j() {
        String valueOf = String.valueOf(45);
        if (TiebaApplication.g().am() == 0) {
            if (c()) {
                valueOf = String.valueOf(80);
            }
        } else if (TiebaApplication.g().am() == 1) {
            valueOf = String.valueOf(80);
        }
        this.e = valueOf;
    }

    public void f() {
        int i = BdWebErrorView.ERROR_CODE_900;
        switch (TiebaApplication.g().al()) {
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
