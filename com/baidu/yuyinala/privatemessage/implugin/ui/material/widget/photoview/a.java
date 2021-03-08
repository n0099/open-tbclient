package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
/* loaded from: classes10.dex */
public class a {
    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int NT(int i) {
        return Build.VERSION.SDK_INT >= 11 ? NV(i) : NU(i);
    }

    @TargetApi(5)
    private static int NU(int i) {
        return (65280 & i) >> 8;
    }

    @TargetApi(11)
    private static int NV(int i) {
        return (65280 & i) >> 8;
    }
}
