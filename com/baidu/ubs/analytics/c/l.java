package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class l {
    private static String kWA;
    private static String kWz;
    private final LinkedHashMap<String, Long> kWB = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Lj(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kWB) {
                this.kWB.put(str, Long.valueOf(System.currentTimeMillis()));
                kWz = str;
                kWA = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Lk(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kWB) {
                Long remove = this.kWB.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kWn;
                        lVar.setPath(dVar.cXx());
                        lVar.x(m.cXH().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.LA(e.toString());
                        com.baidu.ubs.analytics.d.b.Lt(e.toString());
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
