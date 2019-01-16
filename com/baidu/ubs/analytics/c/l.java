package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String ihp;
    private static String ihq;
    private final LinkedHashMap<String, Long> ihr = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yK(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.ihr) {
                this.ihr.put(str, Long.valueOf(System.currentTimeMillis()));
                ihp = str;
                ihq = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yL(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.ihr) {
                Long remove = this.ihr.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.ihe;
                        lVar.setPath(dVar.bTn());
                        lVar.x(m.bTt().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.zb(e.toString());
                        com.baidu.ubs.analytics.d.b.yU(e.toString());
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
