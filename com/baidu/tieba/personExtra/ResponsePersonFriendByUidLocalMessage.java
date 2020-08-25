package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes18.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    private bb mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY);
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonFriendData(bb bbVar) {
        this.mData = bbVar;
    }

    public bb getPersonFriendData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) throws Exception {
        if (str != null) {
            this.mData = new bb();
            this.mData.parserJson(str);
        }
    }
}
