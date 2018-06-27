package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l {
    private static String hCf;
    private static String hCg;
    private final LinkedHashMap<String, Long> hCh = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vT(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hCh) {
                this.hCh.put(str, Long.valueOf(System.currentTimeMillis()));
                hCf = str;
                hCg = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vU(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hCh) {
                Long remove = this.hCh.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hBU;
                        lVar.setPath(dVar.bKw());
                        lVar.x(m.bKF().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.wk(e.toString());
                        com.baidu.ubs.analytics.d.b.wd(e.toString());
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
