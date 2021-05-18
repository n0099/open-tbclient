package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.squareup.wire.Wire;
import d.a.k0.r1.h.a.f;
import tbclient.Error;
import tbclient.SetTail.SetTailResIdl;
/* loaded from: classes3.dex */
public class SetTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<f> {
    public f resultData;

    public SetTailSocketResponseMessage() {
        super(305104);
    }

    public static f getResult(ResponsedMessage<?> responsedMessage, int i2, byte[] bArr) throws Exception {
        SetTailResIdl setTailResIdl = (SetTailResIdl) new Wire(new Class[0]).parseFrom(bArr, SetTailResIdl.class);
        if (setTailResIdl == null) {
            return null;
        }
        Error error = setTailResIdl.error;
        if (error != null) {
            responsedMessage.setError(error.errorno.intValue());
            responsedMessage.setErrorString(setTailResIdl.error.errmsg);
        }
        if (setTailResIdl.data == null) {
            return null;
        }
        f fVar = new f();
        fVar.b(setTailResIdl.data);
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public f getResultData() {
        return this.resultData;
    }
}
