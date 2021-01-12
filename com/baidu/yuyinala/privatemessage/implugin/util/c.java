package com.baidu.yuyinala.privatemessage.implugin.util;

import android.util.Log;
/* loaded from: classes10.dex */
public class c {
    public static void e(String str, String str2) {
        if (d.oWJ) {
            Log.e("canola" + str, "exception:" + str2);
        }
    }

    public static void d(String str, String str2) {
        if (d.oWJ) {
            Log.d("canola" + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (d.oWJ) {
            Log.w("canola" + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (d.oWJ) {
            Log.i("canola" + str, str2);
        }
    }

    public static boolean isDebugMode() {
        return d.oWJ;
    }
}
