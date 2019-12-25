package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes6.dex */
public class PersonalChatDisplayResponse extends CustomResponsedMessage<Object> {
    public PersonalChatDisplayResponse() {
        super(CmdConfigCustom.CMD_PERSONAL_CHAT_INITED);
    }
}
