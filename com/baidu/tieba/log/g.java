package com.baidu.tieba.log;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class g {
    private static String a = "";
    private static boolean b = false;

    public static boolean a(LoggerItem loggerItem) {
        if (loggerItem == null) {
            return false;
        }
        return a(loggerItem.getType());
    }

    public static boolean a(String str) {
        return com.baidu.adp.lib.a.d.a().b(str) == 0;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace('\t', '@').replace('\n', '@');
    }

    public static void a() {
        try {
            a = com.baidu.adp.lib.g.a.a().c();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.d(e.getMessage());
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(a) && !b) {
            a();
            b = true;
        }
        return a;
    }
}
