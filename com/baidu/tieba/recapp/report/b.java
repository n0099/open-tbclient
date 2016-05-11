package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b dXq;
    private CustomMessageListener dXs = new c(this, 2000994);
    private d dXr = new f();

    public static b aLG() {
        if (dXq == null) {
            synchronized (b.class) {
                if (dXq == null) {
                    dXq = new b();
                }
            }
        }
        return dXq;
    }

    private boolean aLH() {
        return com.baidu.adp.lib.c.e.cS().Z("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.dXs);
    }

    public void a(a aVar) {
        if (aLH() && aVar != null && this.dXr != null) {
            if (i.fq()) {
                this.dXr.b(aVar);
            } else {
                this.dXr.c(aVar);
            }
        }
    }
}
