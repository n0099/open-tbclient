package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.interestlabel.b.b;
import com.squareup.wire.Wire;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes22.dex */
public class ResponseSocketGetLabelMessage extends SocketResponsedMessage {
    public ResponseSocketGetLabelMessage() {
        super(CmdConfigSocket.CMD_GET_INTEREST_LABEL_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
