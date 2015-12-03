package com.baidu.tieba.tbadkCore.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a dBA = null;
    private CustomMessageListener dBB = new b(this, 0);

    public static synchronized a aDU() {
        a aVar;
        synchronized (a.class) {
            if (dBA == null) {
                synchronized (a.class) {
                    if (dBA == null) {
                        dBA = new a();
                    }
                }
            }
            aVar = dBA;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.dBB);
    }
}
