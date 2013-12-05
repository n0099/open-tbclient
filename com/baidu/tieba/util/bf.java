package com.baidu.tieba.util;

import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
/* loaded from: classes.dex */
public class bf {
    public static Date a() {
        return new Date(System.currentTimeMillis());
    }

    public static long a(Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        return (time / Util.MILLSECONDS_OF_HOUR) - ((time / Util.MILLSECONDS_OF_DAY) * 24);
    }
}
