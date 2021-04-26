package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.squareup.wire.Wire;
import d.a.j0.r1.h.a.d;
import tbclient.Error;
import tbclient.GetTails.GetTailsResIdl;
/* loaded from: classes3.dex */
public class GetTailsSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<d> {
    public d resultData;

    public GetTailsSocketResponseMessage() {
        super(305001);
    }

    public static d getResult(ResponsedMessage<?> responsedMessage, int i2, byte[] bArr) throws Exception {
        GetTailsResIdl getTailsResIdl = (GetTailsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTailsResIdl.class);
        if (getTailsResIdl == null) {
            return null;
        }
        Error error = getTailsResIdl.error;
        if (error != null) {
            responsedMessage.setError(error.errorno.intValue());
            responsedMessage.setErrorString(getTailsResIdl.error.errmsg);
        }
        if (getTailsResIdl.data == null) {
            return null;
        }
        d dVar = new d();
        dVar.c(getTailsResIdl.data);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public d getResultData() {
        return this.resultData;
    }
}
