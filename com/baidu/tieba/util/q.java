package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f2499a;
    private static Handler b = new Handler();
    private static Runnable c = new r();
    private boolean d;

    public static q a() {
        return new q();
    }

    private q() {
    }

    public void a(String str, int i, int i2) {
        if (!this.d && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                b.removeCallbacks(c);
                if (f2499a != null) {
                    f2499a.setText(trim);
                } else {
                    f2499a = Toast.makeText(TiebaApplication.g(), trim, 0);
                    f2499a.setGravity(17, 0, i2);
                }
                b.postDelayed(c, i);
                f2499a.show();
            }
        }
    }

    public void a(String str, int i) {
        a(str, i, UtilHelper.a((Context) TiebaApplication.g(), 100.0f));
    }

    public void a(int i, int i2) {
        a(TiebaApplication.g().getResources().getString(i), i2);
    }

    public void a(int i, int i2, int i3) {
        a(TiebaApplication.g().getResources().getString(i), i2, i3);
    }

    public void b() {
        this.d = true;
        d();
    }

    public void c() {
        this.d = false;
    }

    public static void d() {
        if (f2499a != null) {
            b.removeCallbacks(c);
            f2499a.cancel();
            f2499a = null;
        }
    }
}
