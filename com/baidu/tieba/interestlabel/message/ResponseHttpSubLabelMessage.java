package com.baidu.tieba.interestlabel.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SubTagList.SubTagListResIdl;
/* loaded from: classes23.dex */
public class ResponseHttpSubLabelMessage extends TbHttpResponsedMessage {
    public ResponseHttpSubLabelMessage() {
        super(1003334);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
