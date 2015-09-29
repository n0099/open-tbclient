package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a daE = null;
    private CustomMessageListener daF = new b(this, 0);

    public static synchronized a axp() {
        a aVar;
        synchronized (a.class) {
            if (daE == null) {
                synchronized (a.class) {
                    if (daE == null) {
                        daE = new a();
                    }
                }
            }
            aVar = daE;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.daF);
    }
}
