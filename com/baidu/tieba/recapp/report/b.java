package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b dCG;
    private CustomMessageListener dCI = new c(this, 2000994);
    private d dCH = new f();

    public static b aEK() {
        if (dCG == null) {
            synchronized (b.class) {
                if (dCG == null) {
                    dCG = new b();
                }
            }
        }
        return dCG;
    }

    private boolean aEL() {
        return com.baidu.adp.lib.c.e.gE().ai("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.dCI);
    }

    public void a(a aVar) {
        if (aEL() && aVar != null && this.dCH != null) {
            if (i.iZ()) {
                this.dCH.b(aVar);
            } else {
                this.dCH.c(aVar);
            }
        }
    }
}
