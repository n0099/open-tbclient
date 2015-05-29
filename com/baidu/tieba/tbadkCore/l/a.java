package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class a {
    private static a ctW = null;
    private CustomMessageListener ctX = new b(this, 0);

    public static synchronized a apt() {
        a aVar;
        synchronized (a.class) {
            if (ctW == null) {
                synchronized (a.class) {
                    if (ctW == null) {
                        ctW = new a();
                    }
                }
            }
            aVar = ctW;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(2001327, this.ctX);
    }
}
