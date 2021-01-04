package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.SubTagList.SubTagListResIdl;
/* loaded from: classes8.dex */
public class ResponseSocketSubLabelMessage extends SocketResponsedMessage {
    public ResponseSocketSubLabelMessage() {
        super(CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SubTagListResIdl subTagListResIdl = (SubTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, SubTagListResIdl.class);
        if (subTagListResIdl != null) {
            setError(subTagListResIdl.error.errorno.intValue());
            setErrorString(subTagListResIdl.error.usermsg);
            if (getError() != 0) {
            }
        }
    }
}
