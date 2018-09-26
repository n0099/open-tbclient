package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l {
    private static String hLi;
    private static String hLj;
    private final LinkedHashMap<String, Long> hLk = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hLk) {
                this.hLk.put(str, Long.valueOf(System.currentTimeMillis()));
                hLi = str;
                hLj = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wK(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hLk) {
                Long remove = this.hLk.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hKX;
                        lVar.setPath(dVar.bLV());
                        lVar.x(m.bMe().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.xa(e.toString());
                        com.baidu.ubs.analytics.d.b.wT(e.toString());
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
