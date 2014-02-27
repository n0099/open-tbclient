package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public final class bs {
    private static bs a;
    private com.baidu.adp.lib.d.a<String, String> b;

    private bs() {
        this.b = null;
        this.b = new com.baidu.adp.lib.d.a<>(256);
    }

    public static synchronized bs a() {
        bs bsVar;
        synchronized (bs.class) {
            if (a == null) {
                a = new bs();
            }
            bsVar = a;
        }
        return bsVar;
    }

    public final void a(String str, Long l) {
        if (str != null && str.length() > 0) {
            this.b.a(String.valueOf(TiebaApplication.v()) + str, String.valueOf(l));
        }
    }

    public final boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String a2 = this.b.a((com.baidu.adp.lib.d.a<String, String>) (String.valueOf(TiebaApplication.v()) + str));
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return UtilHelper.a(com.baidu.adp.lib.f.b.a(a2, 0L), System.currentTimeMillis());
    }
}
