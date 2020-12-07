package com.baidu.ufosdk.screencapedt;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
/* loaded from: classes22.dex */
public final class j {
    public static int a(Context context, float f) {
        return (int) (context.getResources().getDisplayMetrics().density * f);
    }

    public static Pair a(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
