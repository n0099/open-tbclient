package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.g1.b.b;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketGetLabelMessage extends SocketResponsedMessage {
    public ResponseSocketGetLabelMessage() {
        super(309467);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTagListResIdl getTagListResIdl = (GetTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTagListResIdl.class);
        if (getTagListResIdl == null) {
            return;
        }
        setError(getTagListResIdl.error.errorno.intValue());
        setErrorString(getTagListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        RequestGetLabelMessage requestGetLabelMessage = getOrginalMessage().getExtra() instanceof RequestGetLabelMessage ? (RequestGetLabelMessage) getOrginalMessage().getExtra() : null;
        b labelDataSet = requestGetLabelMessage != null ? requestGetLabelMessage.getLabelDataSet() : null;
        if (labelDataSet != null) {
            labelDataSet.d(getTagListResIdl.data);
        }
    }
}
