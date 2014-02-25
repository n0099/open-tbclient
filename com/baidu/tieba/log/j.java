package com.baidu.tieba.log;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.s;
/* loaded from: classes.dex */
public class j {
    private static LoggerItem a = new LoggerItem(h.c);

    public static synchronized String a(String str, String str2, String str3, String str4, String str5) {
        String loggerItem;
        synchronized (j.class) {
            if (!g.a(a)) {
                loggerItem = null;
            } else {
                a.clear();
                a.put("client_ip", g.b(s.a()));
                a.put(SocialConstants.PARAM_URL, g.b(str));
                a.put("downloadTime", g.b(str2));
                a.put("dataSize", g.b(str3));
                a.put("errMsg", g.b(str4));
                a.put("remark", g.b(str5));
                a.initBaseData();
                loggerItem = a.toString();
            }
        }
        return loggerItem;
    }
}
