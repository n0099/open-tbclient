package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class a {
    private static a ctX = null;
    private CustomMessageListener ctY = new b(this, 0);

    public static synchronized a apu() {
        a aVar;
        synchronized (a.class) {
            if (ctX == null) {
                synchronized (a.class) {
                    if (ctX == null) {
                        ctX = new a();
                    }
                }
            }
            aVar = ctX;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(2001327, this.ctY);
    }
}
