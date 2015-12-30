package com.baidu.tieba.tbadkCore.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a dJd = null;
    private CustomMessageListener dJe = new b(this, 0);

    public static synchronized a aGh() {
        a aVar;
        synchronized (a.class) {
            if (dJd == null) {
                synchronized (a.class) {
                    if (dJd == null) {
                        dJd = new a();
                    }
                }
            }
            aVar = dJd;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.dJe);
    }
}
