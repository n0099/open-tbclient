package com.baidu.webkit.internal.utils;

import android.content.SharedPreferences;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes9.dex */
public class b {
    private static SharedPreferences a = null;

    private static SharedPreferences a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = WebViewFactory.getContext().getSharedPreferences("zeus_init_config", 0);
                }
            }
        }
        return a;
    }

    public static String a(String str) {
        return a().getString(str, null);
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor edit = a().edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
