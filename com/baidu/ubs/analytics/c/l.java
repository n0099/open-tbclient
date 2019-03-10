package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jxn;
    private static String jxo;
    private final LinkedHashMap<String, Long> jxp = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EP(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jxp) {
                this.jxp.put(str, Long.valueOf(System.currentTimeMillis()));
                jxn = str;
                jxo = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EQ(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jxp) {
                Long remove = this.jxp.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jxd;
                        lVar.setPath(dVar.cst());
                        lVar.x(m.csB().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Fg(e.toString());
                        com.baidu.ubs.analytics.d.b.EZ(e.toString());
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
