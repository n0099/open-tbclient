package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class l {
    private static String nqC;
    private static String nqD;
    private final LinkedHashMap<String, Long> nqE = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Un(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.nqE) {
                this.nqE.put(str, Long.valueOf(System.currentTimeMillis()));
                nqC = str;
                nqD = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Uo(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.nqE) {
                Long remove = this.nqE.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.nqr;
                        lVar.setPath(dVar.Vd());
                        lVar.x(m.dQF().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.G(e.toString());
                        com.baidu.ubs.analytics.d.b.I(e.toString());
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
