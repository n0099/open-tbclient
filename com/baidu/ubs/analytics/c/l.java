package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class l {
    private static String aE;
    private static String oUE;
    private final LinkedHashMap<String, Long> oUF = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void XI(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.oUF) {
                this.oUF.put(str, Long.valueOf(System.currentTimeMillis()));
                oUE = str;
                aE = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void XJ(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.oUF) {
                Long remove = this.oUF.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.oUu;
                        lVar.setPath(dVar.adI());
                        lVar.x(m.eiq().I());
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
