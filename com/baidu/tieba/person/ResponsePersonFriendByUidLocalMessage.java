package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private com.baidu.tbadk.core.data.r mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(2001186);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonListData(com.baidu.tbadk.core.data.r rVar) {
        this.mData = rVar;
    }

    public com.baidu.tbadk.core.data.r getPersonListData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, String str) {
        if (str != null) {
            this.mData = new com.baidu.tbadk.core.data.r();
            this.mData.parserJson(str);
        }
    }
}
