package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String hUa;
    private static String hUb;
    private final LinkedHashMap<String, Long> hUc = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hUc) {
                this.hUc.put(str, Long.valueOf(System.currentTimeMillis()));
                hUa = str;
                hUb = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void xK(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hUc) {
                Long remove = this.hUc.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hTP;
                        lVar.setPath(dVar.bQl());
                        lVar.x(m.bQu().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.ya(e.toString());
                        com.baidu.ubs.analytics.d.b.xT(e.toString());
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
