package com.baidu.tieba.tbadkCore.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a dZd = null;
    private CustomMessageListener dZe = new b(this, 0);

    public static synchronized a aNm() {
        a aVar;
        synchronized (a.class) {
            if (dZd == null) {
                synchronized (a.class) {
                    if (dZd == null) {
                        dZd = new a();
                    }
                }
            }
            aVar = dZd;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.dZe);
    }
}
