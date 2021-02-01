package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.FinishMemberTask.FinishMemberTaskResIdl;
/* loaded from: classes9.dex */
public class FinishMemberTaskSocketMessage extends SocketResponsedMessage {
    private int status;

    public int getStatus() {
        return this.status;
    }

    public FinishMemberTaskSocketMessage() {
        super(CmdConfigSocket.CMD_FINISH_MEMBER_TASK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
