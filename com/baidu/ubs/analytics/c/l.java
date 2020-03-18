package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class l {
    private static String kYc;
    private static String kYd;
    private final LinkedHashMap<String, Long> kYe = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Li(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kYe) {
                this.kYe.put(str, Long.valueOf(System.currentTimeMillis()));
                kYc = str;
                kYd = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Lj(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kYe) {
                Long remove = this.kYe.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kXQ;
                        lVar.setPath(dVar.cXV());
                        lVar.x(m.cYe().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lz(e.toString());
                        com.baidu.ubs.analytics.d.b.Ls(e.toString());
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
