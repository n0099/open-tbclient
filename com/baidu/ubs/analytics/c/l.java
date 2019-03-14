package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jxf;
    private static String jxg;
    private final LinkedHashMap<String, Long> jxh = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EN(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jxh) {
                this.jxh.put(str, Long.valueOf(System.currentTimeMillis()));
                jxf = str;
                jxg = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EO(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jxh) {
                Long remove = this.jxh.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jwV;
                        lVar.setPath(dVar.csw());
                        lVar.x(m.csE().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Fe(e.toString());
                        com.baidu.ubs.analytics.d.b.EX(e.toString());
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
