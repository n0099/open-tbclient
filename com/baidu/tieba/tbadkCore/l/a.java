package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a dbe = null;
    private CustomMessageListener dbf = new b(this, 0);

    public static synchronized a axv() {
        a aVar;
        synchronized (a.class) {
            if (dbe == null) {
                synchronized (a.class) {
                    if (dbe == null) {
                        dbe = new a();
                    }
                }
            }
            aVar = dbe;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.dbf);
    }
}
