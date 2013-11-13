package com.baidu.tieba.voice.a;

import android.content.Context;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f2613a;
    private com.baidu.adp.lib.e.c b = com.baidu.adp.lib.e.c.a();

    private f() {
        this.b.a(com.baidu.tieba.util.a.e.a());
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f2613a == null) {
                f2613a = new f();
            }
            fVar = f2613a;
        }
        return fVar;
    }

    public void a(Context context, String str) {
        this.b.a(str, context);
    }

    public d a(Context context, String str, String str2, com.baidu.adp.lib.e.b<d> bVar) {
        try {
            com.baidu.adp.lib.e.f fVar = new com.baidu.adp.lib.e.f();
            fVar.a("from", str2);
            return (d) this.b.a(str, 273, bVar, context, fVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
