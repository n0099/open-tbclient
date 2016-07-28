package com.baidu.tieba.tbadkCore.tiebaSwitchMsg;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    static {
        a aVar = new a(0);
        if (TbadkCoreApplication.m10getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_PLUGIN_CONFIG_SYNC);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_PLUGIN_CONFIG_SYNC, aVar);
        }
    }
}
