package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private com.baidu.tbadk.core.data.ai mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonListData(com.baidu.tbadk.core.data.ai aiVar) {
        this.mData = aiVar;
    }

    public com.baidu.tbadk.core.data.ai getPersonListData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) {
        if (str != null) {
            this.mData = new com.baidu.tbadk.core.data.ai();
            this.mData.parserJson(str);
        }
    }
}
