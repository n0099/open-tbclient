package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private com.baidu.tieba.data.al mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(2001186);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonListData(com.baidu.tieba.data.al alVar) {
        this.mData = alVar;
    }

    public com.baidu.tieba.data.al getPersonListData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, String str) {
        if (str != null) {
            this.mData = new com.baidu.tieba.data.al();
            this.mData.a(str);
        }
    }
}
