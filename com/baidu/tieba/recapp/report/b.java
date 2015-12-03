package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class b {
    private static b dhV;
    private CustomMessageListener dhX = new c(this, 2000994);
    private d dhW = new f();

    public static b avU() {
        if (dhV == null) {
            synchronized (b.class) {
                if (dhV == null) {
                    dhV = new b();
                }
            }
        }
        return dhV;
    }

    private boolean avV() {
        return com.baidu.adp.lib.c.e.gw().aj("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.dhX);
    }

    public void a(a aVar) {
        if (avV() && aVar != null && this.dhW != null) {
            if (i.iP()) {
                this.dhW.b(aVar);
            } else {
                this.dhW.c(aVar);
            }
        }
    }
}
