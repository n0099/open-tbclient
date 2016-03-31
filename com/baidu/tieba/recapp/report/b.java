package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b dUy;
    private CustomMessageListener dUA = new c(this, 2000994);
    private d dUz = new f();

    public static b aLC() {
        if (dUy == null) {
            synchronized (b.class) {
                if (dUy == null) {
                    dUy = new b();
                }
            }
        }
        return dUy;
    }

    private boolean aLD() {
        return com.baidu.adp.lib.c.e.gE().ai("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.dUA);
    }

    public void a(a aVar) {
        if (aLD() && aVar != null && this.dUz != null) {
            if (i.jf()) {
                this.dUz.b(aVar);
            } else {
                this.dUz.c(aVar);
            }
        }
    }
}
