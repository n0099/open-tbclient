package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a cKz = null;
    private CustomMessageListener cKA = new b(this, 0);

    public static synchronized a aqO() {
        a aVar;
        synchronized (a.class) {
            if (cKz == null) {
                synchronized (a.class) {
                    if (cKz == null) {
                        cKz = new a();
                    }
                }
            }
            aVar = cKz;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.cKA);
    }
}
