package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PersonalMsglistAdapterStatic {
    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN));
    }
}
