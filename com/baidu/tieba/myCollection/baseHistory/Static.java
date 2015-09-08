package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_ADD_HISTORY));
    }
}
