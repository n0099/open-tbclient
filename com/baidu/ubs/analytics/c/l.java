package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jPM;
    private static String jPN;
    private final LinkedHashMap<String, Long> jPO = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Gh(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jPO) {
                this.jPO.put(str, Long.valueOf(System.currentTimeMillis()));
                jPM = str;
                jPN = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Gi(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jPO) {
                Long remove = this.jPO.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jPC;
                        lVar.setPath(dVar.cAr());
                        lVar.x(m.cAB().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gy(e.toString());
                        com.baidu.ubs.analytics.d.b.Gr(e.toString());
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
