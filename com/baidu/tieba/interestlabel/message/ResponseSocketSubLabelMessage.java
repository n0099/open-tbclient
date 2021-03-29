package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SubTagList.SubTagListResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketSubLabelMessage extends SocketResponsedMessage {
    public ResponseSocketSubLabelMessage() {
        super(309468);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SubTagListResIdl subTagListResIdl = (SubTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, SubTagListResIdl.class);
        if (subTagListResIdl == null) {
            return;
        }
        setError(subTagListResIdl.error.errorno.intValue());
        setErrorString(subTagListResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
