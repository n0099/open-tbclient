package com.baidu.tieba.topRec;

import android.app.Activity;
/* loaded from: classes.dex */
public final class o {
    Activity a;
    int b = 0;

    public o(Activity activity) {
        this.a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("toprec_first_in", false);
    }
}
