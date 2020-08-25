package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.CheckRealName.CheckRealNameResIdl;
/* loaded from: classes2.dex */
public class CheckRealNameSocketResponseMessage extends SocketResponsedMessage {
    public CheckRealNameSocketResponseMessage() {
        super(CmdConfigSocket.CMD_CHECK_REAL_NAME);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CheckRealNameResIdl checkRealNameResIdl = (CheckRealNameResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckRealNameResIdl.class);
        if (bArr != null && checkRealNameResIdl.error != null) {
            setError(checkRealNameResIdl.error.errorno.intValue());
            setErrorString(checkRealNameResIdl.error.errmsg);
        }
    }
}
