package com.baidu.tieba.log;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f1918a = "";

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
        f1918a = com.baidu.adp.lib.g.a.a().c();
    }

    public static String b() {
        if (TextUtils.isEmpty(f1918a)) {
            a();
        }
        return f1918a;
    }
}
