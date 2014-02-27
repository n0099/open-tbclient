package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public final class w {
    private static Toast a;
    private static Handler b = new Handler();
    private static String c = null;
    private static Runnable d = new x();

    public static void a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        b.removeCallbacks(d);
        if (a == null) {
            c = str;
            a = Toast.makeText(context, str, 0);
            a.setGravity(17, 0, BdUtilHelper.a(context, 100.0f));
        } else if (!str.equals(c)) {
            c = str;
            a.setText(str);
        }
        b.postDelayed(d, 2000L);
        a.show();
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
