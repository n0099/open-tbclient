package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b cJn;
    private CustomMessageListener cJp = new c(this, 2000994);
    private d cJo = new f();

    public static b aqi() {
        if (cJn == null) {
            synchronized (b.class) {
                if (cJn == null) {
                    cJn = new b();
                }
            }
        }
        return cJn;
    }

    private boolean aqj() {
        return com.baidu.adp.lib.b.e.gv().af("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cJp);
    }

    public void a(a aVar) {
        if (aqj() && aVar != null && this.cJo != null) {
            if (i.iN()) {
                this.cJo.b(aVar);
            } else {
                this.cJo.c(aVar);
            }
        }
    }
}
