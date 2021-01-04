package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class bj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static bi hV(Context context) {
        if (o.b()) {
            return new bn(new al());
        }
        if (al.a()) {
            return new al();
        }
        if (bm.a()) {
            return new bm(context);
        }
        if (o.a(context)) {
            return new bd();
        }
        if (o.d()) {
            return new bn();
        }
        if (o.c()) {
            return new bf();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (o.e()) {
                return new bo();
            }
            if (o.g()) {
                return new bg();
            }
            if (o.f()) {
                return new be();
            }
            if (o.h()) {
                return new an();
            }
            return new az();
        } else if (!o.a() && bd.c(context)) {
            return new bd();
        } else {
            return null;
        }
    }
}
