package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class cc {

    /* renamed from: a  reason: collision with root package name */
    private static cc f2023a;
    private com.baidu.adp.lib.d.a<String, String> b;

    private cc() {
        this.b = null;
        this.b = new com.baidu.adp.lib.d.a<>(256);
    }

    public static synchronized cc a() {
        cc ccVar;
        synchronized (cc.class) {
            if (f2023a == null) {
                f2023a = new cc();
            }
            ccVar = f2023a;
        }
        return ccVar;
    }

    public void a(String str, Long l) {
        if (str != null && str.length() > 0) {
            this.b.a(TiebaApplication.B() + str, String.valueOf(l));
        }
    }

    public boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String a2 = this.b.a((com.baidu.adp.lib.d.a<String, String>) (TiebaApplication.B() + str));
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return UtilHelper.a(com.baidu.adp.lib.f.b.a(a2, 0L), System.currentTimeMillis());
    }
}
