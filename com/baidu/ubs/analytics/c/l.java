package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String igi;
    private static String igj;
    private final LinkedHashMap<String, Long> igk = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yu(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.igk) {
                this.igk.put(str, Long.valueOf(System.currentTimeMillis()));
                igi = str;
                igj = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yv(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.igk) {
                Long remove = this.igk.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.ifX;
                        lVar.setPath(dVar.bSF());
                        lVar.x(m.bSL().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yL(e.toString());
                        com.baidu.ubs.analytics.d.b.yE(e.toString());
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
