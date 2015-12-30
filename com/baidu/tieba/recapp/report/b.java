package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b dnC;
    private CustomMessageListener dnE = new c(this, 2000994);
    private d dnD = new f();

    public static b axN() {
        if (dnC == null) {
            synchronized (b.class) {
                if (dnC == null) {
                    dnC = new b();
                }
            }
        }
        return dnC;
    }

    private boolean axO() {
        return com.baidu.adp.lib.c.e.gw().aj("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.dnE);
    }

    public void a(a aVar) {
        if (axO() && aVar != null && this.dnD != null) {
            if (i.iQ()) {
                this.dnD.b(aVar);
            } else {
                this.dnD.c(aVar);
            }
        }
    }
}
