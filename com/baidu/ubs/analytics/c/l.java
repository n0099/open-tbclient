package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l {
    private static String hCK;
    private static String hCL;
    private final LinkedHashMap<String, Long> hCM = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vU(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hCM) {
                this.hCM.put(str, Long.valueOf(System.currentTimeMillis()));
                hCK = str;
                hCL = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vV(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hCM) {
                Long remove = this.hCM.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hCz;
                        lVar.setPath(dVar.bJa());
                        lVar.x(m.bJj().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wl(e.toString());
                        com.baidu.ubs.analytics.d.b.we(e.toString());
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
