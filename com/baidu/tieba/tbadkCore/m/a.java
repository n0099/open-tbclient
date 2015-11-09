package com.baidu.tieba.tbadkCore.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a ddp = null;
    private CustomMessageListener ddq = new b(this, 0);

    public static synchronized a ayE() {
        a aVar;
        synchronized (a.class) {
            if (ddp == null) {
                synchronized (a.class) {
                    if (ddp == null) {
                        ddp = new a();
                    }
                }
            }
            aVar = ddp;
        }
        return aVar;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, this.ddq);
    }
}
