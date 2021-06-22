package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.FinishMemberTask.DataRes;
import tbclient.FinishMemberTask.FinishMemberTaskResIdl;
/* loaded from: classes4.dex */
public class FinishMemberTaskSocketMessage extends SocketResponsedMessage {
    public int status;

    public FinishMemberTaskSocketMessage() {
        super(309429);
    }

    public int getStatus() {
        return this.status;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
