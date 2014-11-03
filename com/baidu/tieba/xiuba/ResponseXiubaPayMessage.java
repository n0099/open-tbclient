package com.baidu.tieba.xiuba;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SendXiubaSysMsg.SendXiubaSysMsgResIdl;
/* loaded from: classes.dex */
public class ResponseXiubaPayMessage extends SocketResponsedMessage {
    private ResponsePayData responsePayData;

    public ResponseXiubaPayMessage() {
        super(308006);
    }

    public ResponsePayData getResponsePayData() {
        return this.responsePayData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        SendXiubaSysMsgResIdl sendXiubaSysMsgResIdl = (SendXiubaSysMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, SendXiubaSysMsgResIdl.class);
        setError(sendXiubaSysMsgResIdl.error.errorno.intValue());
        setErrorString(sendXiubaSysMsgResIdl.error.usermsg);
        this.responsePayData = new ResponsePayData();
        this.responsePayData.setErrorCode(getError());
        this.responsePayData.setErrorMsg(getErrorString());
    }
}
