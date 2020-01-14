package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String kVF;
    private static String kVG;
    private final LinkedHashMap<String, Long> kVH = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KV(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.kVH) {
                this.kVH.put(str, Long.valueOf(System.currentTimeMillis()));
                kVF = str;
                kVG = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KW(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.kVH) {
                Long remove = this.kVH.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.kVt;
                        lVar.setPath(dVar.cWg());
                        lVar.x(m.cWq().I());
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
