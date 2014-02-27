package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.adp.lib.e.h;
/* loaded from: classes.dex */
public final class f {
    private static f a;
    private com.baidu.adp.lib.e.c b = com.baidu.adp.lib.e.c.a();

    private f() {
        this.b.a(com.baidu.tieba.util.a.g.a());
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public final void a(Context context, String str) {
        this.b.a(str, context);
    }

    public final d a(Context context, String str, String str2, com.baidu.adp.lib.e.b<d> bVar) {
        try {
            h hVar = new h();
            hVar.a("from", str2);
            return (d) this.b.a(str, 273, bVar, context, hVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
