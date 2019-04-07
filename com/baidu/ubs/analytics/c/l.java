package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {
    private static String jwV;
    private static String jwW;
    private final LinkedHashMap<String, Long> jwX = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EM(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.jwX) {
                this.jwX.put(str, Long.valueOf(System.currentTimeMillis()));
                jwV = str;
                jwW = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void EN(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.jwX) {
                Long remove = this.jwX.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.jwL;
                        lVar.setPath(dVar.csu());
                        lVar.x(m.csE().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.Fd(e.toString());
                        com.baidu.ubs.analytics.d.b.EW(e.toString());
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
