package com.baidu.tieba.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bz {
    private static String a;
    private static final HashMap<String, String> b = new HashMap<>();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        if (b != null) {
            a = b.get(str);
        }
        if (a == null) {
            a = b(str);
            if (b != null) {
                b.put(str, a);
            }
        }
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            return a;
        }
        return a + System.currentTimeMillis();
    }
}
