package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jWQ;
    private static String jWR;
    private final LinkedHashMap<String, Long> jWS = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Hd(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jWS) {
                this.jWS.put(str, Long.valueOf(System.currentTimeMillis()));
                jWQ = str;
                jWR = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void He(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jWS) {
                Long remove = this.jWS.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jWF;
                        lVar.setPath(dVar.cDr());
                        lVar.x(m.cDB().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Hu(e.toString());
                        com.baidu.ubs.analytics.d.b.Hn(e.toString());
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
