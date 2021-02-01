package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.memberCenter.tail.data.b;
import com.squareup.wire.Wire;
import tbclient.AddTail.AddTailResIdl;
/* loaded from: classes9.dex */
public class AddTailSocketResponseMessage extends SocketResponsedMessage {
    private b resultData;

    public AddTailSocketResponseMessage() {
        super(CmdConfigSocket.CMD_TAIL_ADD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public b m37getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    public static b getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        AddTailResIdl addTailResIdl = (AddTailResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTailResIdl.class);
        if (addTailResIdl == null) {
            return null;
        }
        if (addTailResIdl.error != null) {
            responsedMessage.setError(addTailResIdl.error.errorno.intValue());
            responsedMessage.setErrorString(addTailResIdl.error.errmsg);
        }
        if (addTailResIdl.data == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(addTailResIdl.data);
        return bVar;
    }
}
