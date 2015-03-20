package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

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
        com.baidu.tieba.im.e.b(2001147, c.class);
        com.baidu.tieba.im.e.b(2001150, e.class);
        com.baidu.tieba.im.e.b(2001153, d.class);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().registerListener();
    }
}
