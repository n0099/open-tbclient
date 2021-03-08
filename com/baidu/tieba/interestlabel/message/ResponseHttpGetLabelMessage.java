package com.baidu.tieba.interestlabel.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.interestlabel.b.b;
import com.squareup.wire.Wire;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes7.dex */
public class ResponseHttpGetLabelMessage extends TbHttpResponsedMessage {
    public ResponseHttpGetLabelMessage() {
        super(1003333);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTagListResIdl getTagListResIdl = (GetTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTagListResIdl.class);
        if (getTagListResIdl != null) {
            setError(getTagListResIdl.error.errorno.intValue());
            setErrorString(getTagListResIdl.error.usermsg);
            if (getError() == 0) {
                RequestGetLabelMessage requestGetLabelMessage = getOrginalMessage().getExtra() instanceof RequestGetLabelMessage ? (RequestGetLabelMessage) getOrginalMessage().getExtra() : null;
                b labelDataSet = requestGetLabelMessage != null ? requestGetLabelMessage.getLabelDataSet() : null;
                if (labelDataSet != null) {
                    labelDataSet.a(getTagListResIdl.data);
                }
            }
        }
    }
}
