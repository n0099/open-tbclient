package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f2452a;
    private static Handler b = new Handler();
    private static Runnable c = new j();
    private boolean d;

    public static i a() {
        return new i();
    }

    private i() {
    }

    public void a(String str, int i, int i2) {
        if (!this.d && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                b.removeCallbacks(c);
                if (f2452a != null) {
                    f2452a.setText(trim);
                } else {
                    f2452a = Toast.makeText(TiebaApplication.g(), trim, 0);
                    f2452a.setGravity(17, 0, i2);
                }
                b.postDelayed(c, i);
                f2452a.show();
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
        if (f2452a != null) {
            b.removeCallbacks(c);
            f2452a.cancel();
            f2452a = null;
        }
    }
}
