package com.baidu.tieba.mention;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class TiebaRuningTaskStatic {
    static {
        MessageManager.getInstance().registerListener(new aq(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(new ar(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
