package com.baidu.ufosdk.screencapedt;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
/* loaded from: classes5.dex */
public final class j {
    public static int a(Context context, float f2) {
        return (int) (context.getResources().getDisplayMetrics().density * f2);
    }

    public static Pair a(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
