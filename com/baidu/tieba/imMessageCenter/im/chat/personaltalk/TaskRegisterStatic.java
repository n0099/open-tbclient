package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
/* loaded from: classes.dex */
public class TaskRegisterStatic {
    static {
        com.baidu.tieba.im.e.b(205101, ResponsePersonalLbsInfoMessage.class, false);
        com.baidu.tieba.im.e.b(205001, ResponseCommitPersonalMessage.class, false);
        com.baidu.tieba.im.e.b(205003, ResponseQueryUserInfoMessage.class, false);
        com.baidu.tieba.im.e.b(205006, ResponsedPersonalMsgReadMessage.class, false);
        com.baidu.tieba.im.e.b(CmdConfigCustom.CMD_LOAD_DRAFT_PERSONAL, b.class);
        com.baidu.tieba.im.e.b(CmdConfigCustom.CMD_LOAD_HISTORY_PERSONAL, d.class);
        com.baidu.tieba.im.e.b(CmdConfigCustom.CMD_SAVE_DRAFT_PERSONAL, c.class);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xx().registerListener();
    }
}
