package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PersonalChatDisplayResponse extends CustomResponsedMessage<Object> {
    public PersonalChatDisplayResponse() {
        super(CmdConfigCustom.CMD_PERSONAL_CHAT_INITED);
    }
}
