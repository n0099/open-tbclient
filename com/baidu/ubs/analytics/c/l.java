package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class l {
    private static String oIs;
    private static String oIt;
    private final LinkedHashMap<String, Long> oIu = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void XW(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.oIu) {
                this.oIu.put(str, Long.valueOf(System.currentTimeMillis()));
                oIs = str;
                oIt = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void XX(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.oIu) {
                Long remove = this.oIu.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.oIh;
                        lVar.setPath(dVar.adS());
                        lVar.x(m.ejD().I());
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
