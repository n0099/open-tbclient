package com.baidu.tieba.interestlabel.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.i1.b.b;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpGetLabelMessage extends TbHttpResponsedMessage {
    public ResponseHttpGetLabelMessage() {
        super(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
