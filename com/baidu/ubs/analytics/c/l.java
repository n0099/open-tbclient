package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String kVA;
    private static String kVB;
    private final LinkedHashMap<String, Long> kVC = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KV(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kVC) {
                this.kVC.put(str, Long.valueOf(System.currentTimeMillis()));
                kVA = str;
                kVB = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KW(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kVC) {
                Long remove = this.kVC.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kVo;
                        lVar.setPath(dVar.cWe());
                        lVar.x(m.cWo().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Lm(e.toString());
                        com.baidu.ubs.analytics.d.b.Lf(e.toString());
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
