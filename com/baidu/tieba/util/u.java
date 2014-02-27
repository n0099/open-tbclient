package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public final class u {
    private static Toast a;
    private static Handler b = new Handler();
    private static Runnable c = new v();
    private boolean d;

    public static u a() {
        return new u();
    }

    private u() {
    }

    public final void a(String str, int i, int i2) {
        if (!this.d && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                b.removeCallbacks(c);
                if (a != null) {
                    a.setText(trim);
                } else {
                    Toast makeText = Toast.makeText(TiebaApplication.g().b(), trim, 0);
                    a = makeText;
                    makeText.setGravity(17, 0, i2);
                }
                b.postDelayed(c, i);
                a.show();
            }
        }
    }

    public final void a(String str, int i) {
        a(str, i, BdUtilHelper.a((Context) TiebaApplication.g().b(), 100.0f));
    }

    public final void a(int i, int i2) {
        a(TiebaApplication.g().b().getResources().getString(i), 2000);
    }

    public final void a(int i, int i2, int i3) {
        a(TiebaApplication.g().b().getResources().getString(i), 2000, i3);
    }

    public final void b() {
        this.d = true;
        if (a != null) {
            b.removeCallbacks(c);
            a.cancel();
            a = null;
        }
    }

    public final void c() {
        this.d = false;
    }
}
