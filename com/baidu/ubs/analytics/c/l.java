package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class l {
    private static String kRZ;
    private static String kSa;
    private final LinkedHashMap<String, Long> kSb = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KL(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kSb) {
                this.kSb.put(str, Long.valueOf(System.currentTimeMillis()));
                kRZ = str;
                kSa = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KM(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kSb) {
                Long remove = this.kSb.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kRN;
                        lVar.setPath(dVar.cVb());
                        lVar.x(m.cVl().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lc(e.toString());
                        com.baidu.ubs.analytics.d.b.KV(e.toString());
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
