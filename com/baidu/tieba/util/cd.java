package com.baidu.tieba.util;

import java.util.Date;
/* loaded from: classes.dex */
public class cd {
    public static Date a() {
        return new Date(System.currentTimeMillis());
    }

    public static long a(Date date, Date date2) {
        return (date.getTime() - date2.getTime()) / 3600000;
    }
}
