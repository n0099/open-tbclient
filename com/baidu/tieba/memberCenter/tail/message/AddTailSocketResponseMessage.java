package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.squareup.wire.Wire;
import d.a.o0.s1.h.a.b;
import tbclient.AddTail.AddTailResIdl;
import tbclient.Error;
/* loaded from: classes4.dex */
public class AddTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<b> {
    public b resultData;

    public AddTailSocketResponseMessage() {
        super(305101);
    }

    public static b getResult(ResponsedMessage<?> responsedMessage, int i2, byte[] bArr) throws Exception {
        AddTailResIdl addTailResIdl = (AddTailResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTailResIdl.class);
        if (addTailResIdl == null) {
            return null;
        }
        Error error = addTailResIdl.error;
        if (error != null) {
            responsedMessage.setError(error.errorno.intValue());
            responsedMessage.setErrorString(addTailResIdl.error.errmsg);
        }
        if (addTailResIdl.data == null) {
            return null;
        }
        b bVar = new b();
        bVar.b(addTailResIdl.data);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public b getResultData() {
        return this.resultData;
    }
}
