package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.squareup.wire.Wire;
import d.b.j0.r1.h.a.g;
import tbclient.Error;
import tbclient.UpdateTail.UpdateTailResIdl;
/* loaded from: classes3.dex */
public class UpdateTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<g> {
    public g resultData;

    public UpdateTailSocketResponseMessage() {
        super(305102);
    }

    public static g getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        UpdateTailResIdl updateTailResIdl = (UpdateTailResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateTailResIdl.class);
        if (updateTailResIdl == null) {
            return null;
        }
        Error error = updateTailResIdl.error;
        if (error != null) {
            responsedMessage.setError(error.errorno.intValue());
            responsedMessage.setErrorString(updateTailResIdl.error.errmsg);
        }
        if (updateTailResIdl.data == null) {
            return null;
        }
        g gVar = new g();
        gVar.b(updateTailResIdl.data);
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public g getResultData() {
        return this.resultData;
    }
}
