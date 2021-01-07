package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.memberCenter.tail.data.c;
import com.squareup.wire.Wire;
import tbclient.DeleteTail.DeleteTailResIdl;
/* loaded from: classes9.dex */
public class DeleteTailSocketResponseMessage extends SocketResponsedMessage {
    private c resultData;

    public DeleteTailSocketResponseMessage() {
        super(CmdConfigSocket.CMD_TAIL_DELETE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public c m45getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    public static c getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        DeleteTailResIdl deleteTailResIdl = (DeleteTailResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteTailResIdl.class);
        if (deleteTailResIdl == null) {
            return null;
        }
        if (deleteTailResIdl.error != null) {
            responsedMessage.setError(deleteTailResIdl.error.errorno.intValue());
            responsedMessage.setErrorString(deleteTailResIdl.error.errmsg);
        }
        if (deleteTailResIdl.data == null) {
            return null;
        }
        c cVar = new c();
        cVar.a(deleteTailResIdl.data);
        return cVar;
    }
}
