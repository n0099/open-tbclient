package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public class w {
    private static Toast a;
    private static Handler b = new Handler();
    private static String c = null;
    private static Runnable d = new x();

    public static void a(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            b.removeCallbacks(d);
            if (a != null) {
                if (!str.equals(c)) {
                    c = str;
                    a.setText(str);
                }
            } else {
                c = str;
                a = Toast.makeText(context, str, 0);
                a.setGravity(17, 0, BdUtilHelper.a(context, 100.0f));
            }
            b.postDelayed(d, i);
            a.show();
        }
    }

    public static void a(Context context, String str) {
        a(context, str, 2000);
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
