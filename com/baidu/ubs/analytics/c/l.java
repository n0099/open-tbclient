package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String kat;
    private static String kau;
    private final LinkedHashMap<String, Long> kav = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HE(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kav) {
                this.kav.put(str, Long.valueOf(System.currentTimeMillis()));
                kat = str;
                kau = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HF(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kav) {
                Long remove = this.kav.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kai;
                        lVar.setPath(dVar.cEA());
                        lVar.x(m.cEK().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.HV(e.toString());
                        com.baidu.ubs.analytics.d.b.HO(e.toString());
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
