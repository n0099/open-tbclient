package com.baidu.ubs.analytics.c;

import android.text.TextUtils;
import com.baidu.ubs.analytics.c.d;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l {
    private static String mNk;
    private static String mNl;
    private final LinkedHashMap<String, Long> mNm = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void QM(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mNm) {
                this.mNm.put(str, Long.valueOf(System.currentTimeMillis()));
                mNk = str;
                mNl = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void QN(String str) {
        d dVar;
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.mNm) {
                Long remove = this.mNm.remove(str);
                if (remove != null) {
                    try {
                        lVar.setStartTime(String.valueOf(remove));
                        lVar.t(str);
                        lVar.z(String.valueOf(System.currentTimeMillis()));
                        dVar = d.a.mMZ;
                        lVar.setPath(dVar.dAA());
                        lVar.x(m.dAJ().I());
                    } catch (Exception e) {
                        com.baidu.ubs.analytics.d.j.G(e.toString());
                        com.baidu.ubs.analytics.d.b.I(e.toString());
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
