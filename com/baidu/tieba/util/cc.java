package com.baidu.tieba.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class cc {
    private static String a;
    private static String b;
    private static final HashMap<String, String> c = new HashMap<>();

    public static void a(String str) {
        b = str;
        if (TextUtils.isEmpty(str)) {
            a = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (c != null) {
            str2 = c.get(str);
        }
        if (str2 == null) {
            if (TextUtils.isEmpty(str)) {
                str2 = str;
            } else {
                int length = str.length();
                str2 = ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length + (-8) >= 0) ? str.substring(0, length - 8) : str;
            }
            if (c != null) {
                c.put(str, str2);
            }
        }
        if (str2 != null) {
            a = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }
}
