package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.FinishMemberTask.DataRes;
import tbclient.FinishMemberTask.FinishMemberTaskResIdl;
/* loaded from: classes4.dex */
public class FinishMemberTaskHttpResMessage extends TbHttpResponsedMessage {
    public int status;

    public FinishMemberTaskHttpResMessage(int i2) {
        super(i2);
    }

    public int getStatus() {
        return this.status;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        FinishMemberTaskResIdl finishMemberTaskResIdl = (FinishMemberTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, FinishMemberTaskResIdl.class);
        if (finishMemberTaskResIdl == null) {
            return;
        }
        Error error = finishMemberTaskResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(finishMemberTaskResIdl.error.errmsg);
        }
        DataRes dataRes = finishMemberTaskResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.status = dataRes.status.intValue();
    }
}
