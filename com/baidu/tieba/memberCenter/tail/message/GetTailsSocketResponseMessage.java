package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.memberCenter.tail.data.d;
import com.squareup.wire.Wire;
import tbclient.GetTails.GetTailsResIdl;
/* loaded from: classes8.dex */
public class GetTailsSocketResponseMessage extends SocketResponsedMessage {
    private d resultData;

    public GetTailsSocketResponseMessage() {
        super(CmdConfigSocket.CMD_TAIL_GET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public d m42getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = getResult(this, i, bArr);
    }

    public static d getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        GetTailsResIdl getTailsResIdl = (GetTailsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTailsResIdl.class);
        if (getTailsResIdl == null) {
            return null;
        }
        if (getTailsResIdl.error != null) {
            responsedMessage.setError(getTailsResIdl.error.errorno.intValue());
            responsedMessage.setErrorString(getTailsResIdl.error.errmsg);
        }
        if (getTailsResIdl.data == null) {
            return null;
        }
        d dVar = new d();
        dVar.a(getTailsResIdl.data);
        return dVar;
    }
}
