package com.baidu.tieba.xiuba;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SendXiubaSysMsg.SendXiubaSysMsgResIdl;
/* loaded from: classes.dex */
public class ResponseSendXiubaMessage extends SocketResponsedMessage {
    private ResponseSendMsgData sendMsgData;

    public ResponseSendXiubaMessage() {
        super(107202);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        SendXiubaSysMsgResIdl sendXiubaSysMsgResIdl = (SendXiubaSysMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, SendXiubaSysMsgResIdl.class);
        setError(sendXiubaSysMsgResIdl.error.errorno.intValue());
        setErrorString(sendXiubaSysMsgResIdl.error.usermsg);
        this.sendMsgData = new ResponseSendMsgData();
        this.sendMsgData.setErrorCode(getError());
        this.sendMsgData.setErrorMsg(getErrorString());
    }

    public ResponseSendMsgData getSendMsgData() {
        return this.sendMsgData;
    }
}
