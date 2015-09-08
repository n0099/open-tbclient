package com.baidu.tieba.tbadkCore.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a cSZ = null;
    private CustomMessageListener cTa = new b(this, 0);

    public static synchronized a avc() {
        a aVar;
        synchronized (a.class) {
            if (cSZ == null) {
                synchronized (a.class) {
                    if (cSZ == null) {
                        cSZ = new a();
                    }
                }
            }
            aVar = cSZ;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.cTa);
    }
}
