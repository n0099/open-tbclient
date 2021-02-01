package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.FinishMemberTask.FinishMemberTaskResIdl;
/* loaded from: classes9.dex */
public class FinishMemberTaskHttpResMessage extends TbHttpResponsedMessage {
    private int status;

    public int getStatus() {
        return this.status;
    }

    public FinishMemberTaskHttpResMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        FinishMemberTaskResIdl finishMemberTaskResIdl = (FinishMemberTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, FinishMemberTaskResIdl.class);
        if (finishMemberTaskResIdl != null) {
            if (finishMemberTaskResIdl.error != null) {
                setError(finishMemberTaskResIdl.error.errorno.intValue());
                setErrorString(finishMemberTaskResIdl.error.errmsg);
            }
            if (finishMemberTaskResIdl.data != null) {
                this.status = finishMemberTaskResIdl.data.status.intValue();
            }
        }
    }
}
