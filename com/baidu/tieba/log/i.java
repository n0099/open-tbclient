package com.baidu.tieba.log;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class i {
    private static LoggerItem a = new LoggerItem(h.b);

    public static synchronized String a(String str, String str2, String str3) {
        String a2;
        synchronized (i.class) {
            a2 = a(0, 0, str, str2, str3, 0, null, 0L, 0, null);
        }
        return a2;
    }

    public static synchronized String a(String str, String str2, String str3, int i, String str4) {
        String a2;
        synchronized (i.class) {
            a2 = a(0, 0, str, str2, str3, i, str4, 0L, 0, null);
        }
        return a2;
    }

    public static synchronized String a(int i, int i2, String str, String str2, String str3, int i3, String str4) {
        String a2;
        synchronized (i.class) {
            a2 = a(i, i2, str, str2, str3, i3, str4, 0L, 0, null);
        }
        return a2;
    }

    public static synchronized String a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
        String a2;
        synchronized (i.class) {
            a2 = a(i, i2, str, str2, str3, i3, str4, j, 0, null);
        }
        return a2;
    }

    public static synchronized String a(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        String loggerItem;
        synchronized (i.class) {
            if (!g.a(a)) {
                loggerItem = null;
            } else {
                a.clear();
                a.put("cmd", String.valueOf(i));
                String a2 = j.a(i);
                LoggerItem loggerItem2 = a;
                if (TextUtils.isEmpty(a2)) {
                    a2 = "";
                }
                loggerItem2.put("cmdRemark", a2);
                a.put("seqID", String.valueOf(i2));
                LoggerItem loggerItem3 = a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                loggerItem3.put("reason", str);
                LoggerItem loggerItem4 = a;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                loggerItem4.put("action", str2);
                LoggerItem loggerItem5 = a;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                loggerItem5.put("result", str3);
                a.put("errorCode", String.valueOf(i3));
                LoggerItem loggerItem6 = a;
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                loggerItem6.put("errorMsg", str4);
                a.put("costTime", String.valueOf(j));
                a.put("size", String.valueOf(i4));
                LoggerItem loggerItem7 = a;
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                loggerItem7.put("comment", str5);
                a.initBaseData();
                loggerItem = a.toString();
            }
        }
        return loggerItem;
    }
}
