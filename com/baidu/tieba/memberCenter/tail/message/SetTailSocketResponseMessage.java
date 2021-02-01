package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.memberCenter.tail.data.f;
import com.squareup.wire.Wire;
import tbclient.SetTail.SetTailResIdl;
/* loaded from: classes9.dex */
public class SetTailSocketResponseMessage extends SocketResponsedMessage {
    private f resultData;

    public SetTailSocketResponseMessage() {
        super(CmdConfigSocket.CMD_TAIL_SET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public f m43getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    public static f getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        SetTailResIdl setTailResIdl = (SetTailResIdl) new Wire(new Class[0]).parseFrom(bArr, SetTailResIdl.class);
        if (setTailResIdl == null) {
            return null;
        }
        if (setTailResIdl.error != null) {
            responsedMessage.setError(setTailResIdl.error.errorno.intValue());
            responsedMessage.setErrorString(setTailResIdl.error.errmsg);
        }
        if (setTailResIdl.data == null) {
            return null;
        }
        f fVar = new f();
        fVar.a(setTailResIdl.data);
        return fVar;
    }
}
