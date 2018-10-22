package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String hUb;
    private static String hUc;
    private final LinkedHashMap<String, Long> hUd = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hUd) {
                this.hUd.put(str, Long.valueOf(System.currentTimeMillis()));
                hUb = str;
                hUc = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xK(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hUd) {
                Long remove = this.hUd.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hTQ;
                        lVar.setPath(dVar.bQl());
                        lVar.x(m.bQu().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.ya(e.toString());
                        com.baidu.ubs.analytics.d.b.xT(e.toString());
                    }
                    com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.l.1
                        @Override // com.baidu.ubs.analytics.d.d
                        protected final void a() {
                            new com.baidu.ubs.analytics.a.m().b(lVar);
                        }
                    });
                }
            }
        }
    }
}
