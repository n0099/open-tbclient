package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f2500a;
    private static Handler b = new Handler();
    private static String c = null;
    private static Runnable d = new t();

    public static void a(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            b.removeCallbacks(d);
            if (f2500a != null) {
                if (!str.equals(c)) {
                    c = str;
                    f2500a.setText(str);
                }
            } else {
                c = str;
                f2500a = Toast.makeText(context, str, 0);
                f2500a.setGravity(17, 0, UtilHelper.a(context, 100.0f));
            }
            b.postDelayed(d, i);
            f2500a.show();
        }
    }

    public static void a(Context context, String str) {
        a(context, str, 2000);
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
