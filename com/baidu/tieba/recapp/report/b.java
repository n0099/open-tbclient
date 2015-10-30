package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b cHR;
    private CustomMessageListener cHT = new c(this, 2000994);
    private d cHS = new f();

    public static b apC() {
        if (cHR == null) {
            synchronized (b.class) {
                if (cHR == null) {
                    cHR = new b();
                }
            }
        }
        return cHR;
    }

    private boolean apD() {
        return com.baidu.adp.lib.b.e.gv().ah("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cHT);
    }

    public void a(a aVar) {
        if (apD() && aVar != null && this.cHS != null) {
            if (i.iM()) {
                this.cHS.b(aVar);
            } else {
                this.cHS.c(aVar);
            }
        }
    }
}
