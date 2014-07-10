package com.baidu.tieba.person;

import java.util.Date;
/* loaded from: classes.dex */
public class by {
    int a;
    int b;

    public String a() {
        if (this.a == 0 || this.b == 0) {
            return null;
        }
        return String.valueOf(String.format("%.2f", Double.valueOf(this.a / 1000.0d))) + "km | " + com.baidu.tbadk.core.util.bm.a(new Date(), new Date(Long.valueOf(this.b).longValue() * 1000));
    }
}
