package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l {
    private static String hCM;
    private static String hCN;
    private final LinkedHashMap<String, Long> hCO = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vY(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hCO) {
                this.hCO.put(str, Long.valueOf(System.currentTimeMillis()));
                hCM = str;
                hCN = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vZ(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hCO) {
                Long remove = this.hCO.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hCB;
                        lVar.setPath(dVar.bJe());
                        lVar.x(m.bJn().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wp(e.toString());
                        com.baidu.ubs.analytics.d.b.wi(e.toString());
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
