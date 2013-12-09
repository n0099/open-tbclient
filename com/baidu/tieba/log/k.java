package com.baidu.tieba.log;

import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static LoggerItem f1923a = new LoggerItem(h.c);

    public static synchronized String a(String str, String str2, String str3, String str4, String str5) {
        String loggerItem;
        synchronized (k.class) {
            if (!g.a(f1923a)) {
                loggerItem = null;
            } else {
                f1923a.clear();
                f1923a.put(SocialConstants.PARAM_URL, g.b(str));
                f1923a.put("downloadTime", g.b(str2));
                f1923a.put("dataSize", g.b(str3));
                f1923a.put("errMsg", g.b(str4));
                f1923a.put("remark", g.b(str5));
                f1923a.initBaseData();
                loggerItem = f1923a.toString();
            }
        }
        return loggerItem;
    }
}
