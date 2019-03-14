package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ar;
/* loaded from: classes6.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private ar mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(2001182);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonFriendData(ar arVar) {
        this.mData = arVar;
    }

    public ar getPersonFriendData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) throws Exception {
        if (str != null) {
            this.mData = new ar();
            this.mData.parserJson(str);
        }
    }
}
