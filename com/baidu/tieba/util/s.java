package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f2517a;
    private static Handler b = new Handler();
    private static Runnable c = new t();

    public static void a(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            b.removeCallbacks(c);
            if (f2517a != null) {
                f2517a.setText(str);
            } else {
                f2517a = Toast.makeText(context, str, 0);
                f2517a.setGravity(17, 0, UtilHelper.a(context, 100.0f));
            }
            b.postDelayed(c, i);
            f2517a.show();
        }
    }

    public static void a(Context context, String str) {
        a(context, str, 2000);
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
