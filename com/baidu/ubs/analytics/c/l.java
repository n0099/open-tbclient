package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String icV;
    private static String icW;
    private final LinkedHashMap<String, Long> icX = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yr(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.icX) {
                this.icX.put(str, Long.valueOf(System.currentTimeMillis()));
                icV = str;
                icW = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ys(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.icX) {
                Long remove = this.icX.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.icK;
                        lVar.setPath(dVar.bRO());
                        lVar.x(m.bRU().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.yI(e.toString());
                        com.baidu.ubs.analytics.d.b.yB(e.toString());
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
