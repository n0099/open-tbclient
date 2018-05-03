package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l {
    private static String hla;
    private static String hlb;
    private final LinkedHashMap<String, Long> hlc = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void va(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.hlc) {
                this.hlc.put(str, Long.valueOf(System.currentTimeMillis()));
                hla = str;
                hlb = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void vb(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.hlc) {
                Long remove = this.hlc.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.hkO;
                        lVar.setPath(dVar.bET());
                        lVar.x(m.bFd().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.vr(e.toString());
                        com.baidu.ubs.analytics.d.b.vk(e.toString());
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
