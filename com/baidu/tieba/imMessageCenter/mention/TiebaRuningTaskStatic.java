package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class TiebaRuningTaskStatic {
    static {
        MessageManager.getInstance().registerListener(new bi(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(new bj(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
