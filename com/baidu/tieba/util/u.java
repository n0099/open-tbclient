package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class u {
    private static Toast a;
    private static Handler b = new Handler();
    private static Runnable c = new v();
    private boolean d;

    public static u a() {
        return new u();
    }

    private u() {
    }

    public void a(String str, int i, int i2) {
        if (!this.d && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                b.removeCallbacks(c);
                if (a != null) {
                    a.setText(trim);
                } else {
                    a = Toast.makeText(TiebaApplication.g().b(), trim, 0);
                    a.setGravity(17, 0, i2);
                }
                b.postDelayed(c, i);
                a.show();
            }
        }
    }

    public void a(String str, int i) {
        a(str, i, BdUtilHelper.a((Context) TiebaApplication.g().b(), 100.0f));
    }

    public void a(int i, int i2) {
        a(TiebaApplication.g().b().getResources().getString(i), i2);
    }

    public void a(int i, int i2, int i3) {
        a(TiebaApplication.g().b().getResources().getString(i), i2, i3);
    }

    public void b() {
        this.d = true;
        d();
    }

    public void c() {
        this.d = false;
    }

    public static void d() {
        if (a != null) {
            b.removeCallbacks(c);
            a.cancel();
            a = null;
        }
    }
}
