package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ap;
/* loaded from: classes3.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private ap mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(2001182);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonFriendData(ap apVar) {
        this.mData = apVar;
    }

    public ap getPersonFriendData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) throws Exception {
        if (str != null) {
            this.mData = new ap();
            this.mData.parserJson(str);
        }
    }
}
