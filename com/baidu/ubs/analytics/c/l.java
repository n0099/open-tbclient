package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String ihq;
    private static String ihr;
    private final LinkedHashMap<String, Long> ihs = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yK(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.ihs) {
                this.ihs.put(str, Long.valueOf(System.currentTimeMillis()));
                ihq = str;
                ihr = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void yL(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.ihs) {
                Long remove = this.ihs.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.ihf;
                        lVar.setPath(dVar.bTn());
                        lVar.x(m.bTt().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.zb(e.toString());
                        com.baidu.ubs.analytics.d.b.yU(e.toString());
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
