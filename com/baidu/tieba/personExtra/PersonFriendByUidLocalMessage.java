package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes9.dex */
public class PersonFriendByUidLocalMessage extends CustomMessage<String> {
    public PersonFriendByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    }
}
