package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private com.baidu.tieba.person.a.a mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonListData(com.baidu.tieba.person.a.a aVar) {
        this.mData = aVar;
    }

    public com.baidu.tieba.person.a.a getPersonListData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) {
        if (str != null) {
            this.mData = new com.baidu.tieba.person.a.a();
            this.mData.parserJson(str);
        }
    }
}
