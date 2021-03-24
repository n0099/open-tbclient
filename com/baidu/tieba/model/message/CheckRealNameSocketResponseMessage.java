package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CheckRealName.CheckRealNameResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class CheckRealNameSocketResponseMessage extends SocketResponsedMessage {
    public CheckRealNameSocketResponseMessage() {
        super(309456);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        CheckRealNameResIdl checkRealNameResIdl = (CheckRealNameResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckRealNameResIdl.class);
        if (bArr == null || (error = checkRealNameResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(checkRealNameResIdl.error.errmsg);
    }
}
