package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String hVL;
    private static String hVM;
    private final LinkedHashMap<String, Long> hVN = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xO(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hVN) {
                this.hVN.put(str, Long.valueOf(System.currentTimeMillis()));
                hVL = str;
                hVM = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xP(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hVN) {
                Long remove = this.hVN.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hVA;
                        lVar.setPath(dVar.bPJ());
                        lVar.x(m.bPP().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yf(e.toString());
                        com.baidu.ubs.analytics.d.b.xY(e.toString());
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
