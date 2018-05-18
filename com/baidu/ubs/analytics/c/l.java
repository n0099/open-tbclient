package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l {
    private static String hme;
    private static String hmf;
    private final LinkedHashMap<String, Long> hmg = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vd(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hmg) {
                this.hmg.put(str, Long.valueOf(System.currentTimeMillis()));
                hme = str;
                hmf = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ve(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hmg) {
                Long remove = this.hmg.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hlS;
                        lVar.setPath(dVar.bER());
                        lVar.x(m.bFb().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.vu(e.toString());
                        com.baidu.ubs.analytics.d.b.vn(e.toString());
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
