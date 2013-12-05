package com.baidu.tieba.log;

import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static LoggerItem f1922a = new LoggerItem(h.c);

    public static synchronized String a(String str, String str2, String str3, String str4, String str5) {
        String loggerItem;
        synchronized (k.class) {
            if (!g.a(f1922a)) {
                loggerItem = null;
            } else {
                f1922a.clear();
                f1922a.put(SocialConstants.PARAM_URL, g.b(str));
                f1922a.put("downloadTime", g.b(str2));
                f1922a.put("dataSize", g.b(str3));
                f1922a.put("errMsg", g.b(str4));
                f1922a.put("remark", g.b(str5));
                f1922a.initBaseData();
                loggerItem = f1922a.toString();
            }
        }
        return loggerItem;
    }
}
