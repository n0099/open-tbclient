package com.baidu.tieba.log;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class g {
    private static String a = "";
    private static boolean b = false;

    public static boolean a(LoggerItem loggerItem) {
        if (loggerItem == null) {
            return false;
        }
        return com.baidu.adp.lib.a.d.a().b(loggerItem.getType()) == 0;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace('\t', '@').replace('\n', '@');
    }

    public static void a() {
        try {
            a = com.baidu.adp.lib.stats.f.a().b();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.e(e.getMessage());
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
