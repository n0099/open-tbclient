package com.baidu.tieba.util;

import java.util.Date;
/* loaded from: classes.dex */
public class bg {
    public static Date a() {
        return new Date(System.currentTimeMillis());
    }

    public static long a(Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        return (time / 3600000) - ((time / 86400000) * 24);
    }
}
