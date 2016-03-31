package com.baidu.tieba.tbadkCore.tiebaStatMsg;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    static {
        a aVar = new a(0);
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, aVar);
        }
    }
}
