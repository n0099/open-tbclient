package com.baidu.tieba.interestlabel.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SubTagList.SubTagListResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpSubLabelMessage extends TbHttpResponsedMessage {
    public ResponseHttpSubLabelMessage() {
        super(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
