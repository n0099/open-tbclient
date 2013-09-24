package com.baidu.tieba.util;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private static au f1908a = null;
    private boolean b = false;
    private boolean c = false;
    private int d = 300;
    private String e = String.valueOf(45);

    public static au a() {
        if (f1908a == null) {
            synchronized (au.class) {
                f1908a = new au();
            }
        }
        return f1908a;
    }

    public au() {
        g();
        f();
    }

    private void f() {
        h();
        i();
        j();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.b = z;
        f();
    }

    private void g() {
        this.b = UtilHelper.i(TiebaApplication.g().getApplicationContext()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    public boolean c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.d;
    }

    private void h() {
        boolean z = true;
        if (TiebaApplication.g().ak() != 0 ? TiebaApplication.g().ak() != 1 : !this.b) {
            z = false;
        }
        a(z);
    }

    private void i() {
        String valueOf = String.valueOf(45);
        if (TiebaApplication.g().ak() == 0) {
            if (c()) {
                valueOf = String.valueOf(80);
            }
        } else if (TiebaApplication.g().ak() == 1) {
            valueOf = String.valueOf(80);
        }
        this.e = valueOf;
    }

    private void j() {
        int i = BdWebErrorView.ERROR_CODE_900;
        switch (TiebaApplication.g().aj()) {
            case 0:
                if (!c()) {
                    i = 300;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 600;
                break;
            case 3:
                i = 300;
                break;
            default:
                i = 600;
                break;
        }
        this.d = i;
    }
}
