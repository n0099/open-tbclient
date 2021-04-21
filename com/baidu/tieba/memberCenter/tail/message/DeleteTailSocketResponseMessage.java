package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.squareup.wire.Wire;
import d.b.j0.r1.h.a.c;
import tbclient.DeleteTail.DeleteTailResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class DeleteTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<c> {
    public c resultData;

    public DeleteTailSocketResponseMessage() {
        super(305103);
    }

    public static c getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        DeleteTailResIdl deleteTailResIdl = (DeleteTailResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteTailResIdl.class);
        if (deleteTailResIdl == null) {
            return null;
        }
        Error error = deleteTailResIdl.error;
        if (error != null) {
            responsedMessage.setError(error.errorno.intValue());
            responsedMessage.setErrorString(deleteTailResIdl.error.errmsg);
        }
        if (deleteTailResIdl.data == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(deleteTailResIdl.data);
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public c getResultData() {
        return this.resultData;
    }
}
