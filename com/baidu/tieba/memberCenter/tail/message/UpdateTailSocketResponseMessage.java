package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.memberCenter.tail.data.g;
import com.squareup.wire.Wire;
import tbclient.UpdateTail.UpdateTailResIdl;
/* loaded from: classes9.dex */
public class UpdateTailSocketResponseMessage extends SocketResponsedMessage {
    private g resultData;

    public UpdateTailSocketResponseMessage() {
        super(CmdConfigSocket.CMD_TAIL_UPDATE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public g m45getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    public static g getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        UpdateTailResIdl updateTailResIdl = (UpdateTailResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateTailResIdl.class);
        if (updateTailResIdl == null) {
            return null;
        }
        if (updateTailResIdl.error != null) {
            responsedMessage.setError(updateTailResIdl.error.errorno.intValue());
            responsedMessage.setErrorString(updateTailResIdl.error.errmsg);
        }
        if (updateTailResIdl.data == null) {
            return null;
        }
        g gVar = new g();
        gVar.a(updateTailResIdl.data);
        return gVar;
    }
}
