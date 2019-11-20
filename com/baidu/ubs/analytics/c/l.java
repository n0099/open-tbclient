package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jXC;
    private static String jXD;
    private final LinkedHashMap<String, Long> jXE = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void FV(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jXE) {
                this.jXE.put(str, Long.valueOf(System.currentTimeMillis()));
                jXC = str;
                jXD = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void FW(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jXE) {
                Long remove = this.jXE.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jXq;
                        lVar.setPath(dVar.cBj());
                        lVar.x(m.cBt().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Gm(e.toString());
                        com.baidu.ubs.analytics.d.b.Gf(e.toString());
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
