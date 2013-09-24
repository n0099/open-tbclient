package com.baidu.tieba.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f1922a;
    private static Handler b = new Handler();
    private static Runnable c = new j();

    public static void a(Context context, String str, int i) {
        b.removeCallbacks(c);
        if (f1922a != null) {
            f1922a.setText(str);
        } else {
            f1922a = Toast.makeText(context, str, 0);
        }
        b.postDelayed(c, i);
        f1922a.show();
    }
}
