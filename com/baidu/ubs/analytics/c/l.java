package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jXW;
    private static String jXX;
    private final LinkedHashMap<String, Long> jXY = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void He(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jXY) {
                this.jXY.put(str, Long.valueOf(System.currentTimeMillis()));
                jXW = str;
                jXX = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Hf(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jXY) {
                Long remove = this.jXY.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jXL;
                        lVar.setPath(dVar.cDM());
                        lVar.x(m.cDW().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Hv(e.toString());
                        com.baidu.ubs.analytics.d.b.Ho(e.toString());
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
